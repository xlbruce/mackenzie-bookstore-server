package service;

import org.springframework.stereotype.Service;

import model.entities.Book;

@Service
public interface BookRepositoryService extends GeneralRepositoryService<Book, String>{

}
