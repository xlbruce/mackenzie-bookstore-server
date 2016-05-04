package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import api.google.client.GoogleBooksApiClient;
import model.entities.Book;
import repository.BookRepository;

public class BookRepositoryServiceImpl implements BookRepositoryService {

	@Autowired
	private BookRepository bookRepository;
	
	private GoogleBooksApiClient client;
	
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Async
	@Override
	public List<Book> findByName(String name) {
		//TODO must search books asynchronously on Google Books API
		List<Book> books = bookRepository.findByName(name);
		if (books.isEmpty()) {
			client = new GoogleBooksApiClient(name);
			try {
				List<Book> googleBooks = client.getBooks();
				saveAll(googleBooks);
				books.addAll(googleBooks);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return books;
	}

	@Override
	public Book findById(String isbn) {
		return bookRepository.findOne(isbn);
	}

	@Override
	public void saveAll(List<Book> entities) {
		entities.forEach(book -> {
			save(book);
		});
	}

	@Override
	public void save(Book entity) {
		bookRepository.save(entity);
	}

}
