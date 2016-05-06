package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.entities.Book;

@Service
public interface BookRepositoryService {

	List<Book> findByName(String name);
	
	List<Book> findAll();
	
	Book findById(String isbn);
	
	void saveAll(List<Book> books);
	
	void save(Book book);
}
