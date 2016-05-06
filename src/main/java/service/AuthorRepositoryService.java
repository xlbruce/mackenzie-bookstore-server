package service;

import model.entities.Author;

public interface AuthorRepositoryService {
	
	Author findOneByName(String name);

}
