package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.entities.Author;
import repository.AuthorRepository;

public class AuthorRepositoryServiceImpl implements AuthorRepositoryService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public AuthorRepositoryServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@Override
	public Author findOneByName(String name) {
		List<Author> findByName = authorRepository.findByName(name);
		Author author = new Author();
		author.setName(name);
		
		author = findByName.stream()
						.filter(a -> name.equals(a.getName()))
						.findFirst()
						.orElse(author); //If not found, return itself
		
		return author;
	}

}
