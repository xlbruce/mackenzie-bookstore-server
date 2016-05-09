package config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repository.AnnounceRepository;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.PublisherRepository;
import repository.UserRepository;
import repository.UserTypeRepository;
import service.AnnounceRepositoryService;
import service.AnnounceRepositoryServiceImpl;
import service.AuthorRepositoryService;
import service.AuthorRepositoryServiceImpl;
import service.BookRepositoryService;
import service.BookRepositoryServiceImpl;
import service.PublisherRepositoryService;
import service.PublisherRepositoryServiceImpl;
import service.UserRepositoryService;
import service.UserRepositoryServiceImpl;

/**
 *
 * @author gilson
 */
@Configuration
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "model.entities")
public class Config {

	@Bean
	public AuthorRepositoryService authorRepositoryService(AuthorRepository authorRepository) {
		return new AuthorRepositoryServiceImpl(authorRepository);
	}

	@Bean
	public BookRepositoryService bookRepositoryService(BookRepository bookRepository) {
		return new BookRepositoryServiceImpl(bookRepository);
	}

	@Bean
	public PublisherRepositoryService publisherRepositoryService(PublisherRepository publisherRepository) {
		return new PublisherRepositoryServiceImpl(publisherRepository);
	}

	@Bean
	public UserRepositoryService userRepositoryService(UserRepository userRepository,
			UserTypeRepository userTypeRepository) {
		return new UserRepositoryServiceImpl(userRepository, userTypeRepository);
	}

	@Bean
	public AnnounceRepositoryService announceRepositoryService(AnnounceRepository announceRepository,
			UserRepositoryService userRepositoryService, BookRepositoryService bookRepositoryService) {
		return new AnnounceRepositoryServiceImpl(announceRepository, userRepositoryService,
				bookRepositoryService);
	}

}
