package config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.PublisherRepository;
import service.AuthorRepositoryService;
import service.AuthorRepositoryServiceImpl;
import service.BookRepositoryService;
import service.BookRepositoryServiceImpl;
import service.PublisherRepositoryService;
import service.PublisherRepositoryServiceImpl;

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
	
	/*
	 * Maybe will not be used
	@Bean
	public AuthorRepositoryService authorRepositoryService(AuthorRepository authorRepository) {
		return new AuthorRepositoryServiceImpl();
	}
	*/
    
}
