package service;

import java.util.List;

import org.springframework.stereotype.Service;

import exception.BookNotFoundException;
import model.entities.Book;

@Service
public interface BookRepositoryService {

	List<Book> findByName(String name);
	
	List<Book> findAll();
	
	Book findById(String isbn) throws BookNotFoundException;
	
	void saveAll(List<Book> books);
	
	void save(Book book);
}
