package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.entities.Publisher;
import repository.PublisherRepository;

public class PublisherRepositoryServiceImpl implements PublisherRepositoryService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	public PublisherRepositoryServiceImpl(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public Publisher findOneByName(String name) {
		List<Publisher> publishers = publisherRepository.findByName(name);
		Publisher publisher = new Publisher();
		publisher.setName(name);
		
		publisher = publishers.stream()
							  .filter(p -> name.equals(p.getName()))
							  .findFirst()
							  .orElse(publisher); //If not found, return itself
		
		return publisher;
	}

}
