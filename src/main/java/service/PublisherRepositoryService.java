package service;

import model.entities.Publisher;

public interface PublisherRepositoryService {

	Publisher findOneByName(String name);
}
