package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;

import api.google.client.GoogleBooksApiClient;
import exception.BookNotFoundException;
import model.entities.Author;
import model.entities.Book;
import model.entities.Publisher;
import repository.BookRepository;

public class BookRepositoryServiceImpl implements BookRepositoryService {

	private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepositoryService authorRepositoryService;

	@Autowired
	private PublisherRepositoryService publisherRepositoryService;

	private GoogleBooksApiClient client = new GoogleBooksApiClient();

	public BookRepositoryServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> findByName(String name) {
		Future<List<Book>> futureBooks = threadPool.submit(() -> {
			return client.searchBooks(name);
		});

		List<Book> books = bookRepository.findByName(name);
		List<Book> newBooks = new ArrayList<>();
		// TODO update "books" references
		try {
			newBooks = new ArrayList<>(futureBooks.get(1, TimeUnit.MINUTES));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//books.addAll(new LinkedHashSet<>(newBooks)); // Avoid duplicity
		
		books.addAll(newBooks);
		updateBooksReferences(books);
		saveAll(books);
		updateBooksReferences(books);
		return books;
	}

	private void updateBooksReferences(List<Book> books) {
		books.forEach(book -> {
			Author author = book.getAuthor();

			if (author.getIdAuthor() == null) {
				author = authorRepositoryService.findOneByName(author.getName());
				book.setAuthor(author);
			}

			Publisher publisher = book.getPublisher();

			if (publisher.getIdPublisher() == null) {
				publisher = publisherRepositoryService.findOneByName(publisher.getName());
				book.setPublisher(publisher);
			}
		});

	}

	@Override
	public Book findById(String isbn) throws BookNotFoundException {
		Book book = bookRepository.findOne(isbn);
		if (book == null) {
			throw new BookNotFoundException("Livro não encontrado");
		}
		
		return book;
	}

	@Override
	public void saveAll(List<Book> entities) {
		for (Book book : entities) {
			if (book.getAuthor().getIdAuthor() == null) {
				book.setAuthor(authorRepositoryService.findOneByName(book.getAuthor().getName()));
			}
			if (book.getPublisher().getIdPublisher() == null) {
				book.setPublisher(publisherRepositoryService.findOneByName(book.getPublisher().getName()));
			}
			save(book);
		}

	}

	@Override
	public void save(Book book) {
		if (bookRepository.findOne(book.getIsbn()) == null)
			bookRepository.save(book);
	}

}
