package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import exception.BookNotFoundException;
import model.entities.Book;

import service.BookRepositoryService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRepositoryService bookRepositoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> index() {
		return bookRepositoryService.findAll();
	}
	
	@RequestMapping("/{isbn}")
	public Book findByIsbn(@PathVariable("isbn") String isbn) throws BookNotFoundException {
		return bookRepositoryService.findById(isbn);
	}
	
	@RequestMapping("/name/{name}")
	public List<Book> findByName(@PathVariable String name) {
		return bookRepositoryService.findByName(name);
	}
	
}
