package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import api.google.client.GoogleBooksApiClient;
import model.entities.Book;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.PublisherRepository;

public class BookRepositoryServiceImpl implements BookRepositoryService {

	private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	private GoogleBooksApiClient client;
	
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Async
	//@Override
	public List<Book> findByName(String name) {
		Future<List<Book>> futureBooks = threadPool.submit(() -> {
			return client.getBooks();
		});
		
		List<Book> books = bookRepository.findByName(name);
		List<Book> newBooks = new ArrayList<>(futureBooks.get());
		newBooks.removeAll(books);
		
		threadPool.submit(() -> {
			saveAll(newBooks);
		});
		return books;
	}

	@Override
	public Book findById(String isbn) {
		return bookRepository.findOne(isbn);
	}

	//@Override
	public void saveAll(List<Book> entities) {
		entities.forEach(book -> {
			if (book.getAuthor().getIdAuthor() == null) {
				book.setAuthor(authorRepository.findByName(book.getAuthor().getName()).get(0));
			}
			if (book.getPublisher().getIdPublisher() == null) {
				book.setPublisher(publisherRepository.findByName(book.getPublisher().getName()).get(0));
			}
			save(book);
		});
		

	}

	@Override
	public void save(Book entity) {
		bookRepository.save(entity);
	}

}
