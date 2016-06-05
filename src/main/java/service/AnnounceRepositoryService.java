package service;

import java.util.List;

import exception.AnnounceNotFoundException;
import exception.BookNotFoundException;
import exception.UserNotFoundException;
import model.entities.Announce;
import model.entities.AnnouncePK;

public interface AnnounceRepositoryService {

	Announce registerAnnounce(Integer userCode, String isbn, String description)
			throws UserNotFoundException, BookNotFoundException;
	
	List<Announce> findAnnounceByBookName(String bookName);
	
	Announce findById(AnnouncePK id) throws AnnounceNotFoundException;
}
