package service;

import java.util.List;

import exception.BookNotFoundException;
import exception.UserNotFoundException;
import model.entities.Announce;

public interface AnnounceRepositoryService {

	Announce registerAnnounce(Integer userCode, String isbn, String description)
			throws UserNotFoundException, BookNotFoundException;
	
	List<Announce> findAnnounceByBookName(String bookName);
}
