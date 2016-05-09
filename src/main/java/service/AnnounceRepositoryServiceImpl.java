package service;

import org.springframework.beans.factory.annotation.Autowired;

import exception.BookNotFoundException;
import exception.UserNotFoundException;
import model.entities.Announce;
import model.entities.AnnouncePK;
import model.entities.Book;
import model.entities.User;
import repository.AnnounceRepository;

public class AnnounceRepositoryServiceImpl implements AnnounceRepositoryService {

	@Autowired
	private AnnounceRepository announceRepository;
	
	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@Autowired
	private BookRepositoryService bookRepositoryService;

	public AnnounceRepositoryServiceImpl(AnnounceRepository announceRepository,
			UserRepositoryService userRepositoryService, BookRepositoryService bookRepositoryService) {
		this.announceRepository = announceRepository;
		this.userRepositoryService = userRepositoryService;
		this.bookRepositoryService = bookRepositoryService;
	}

	@Override
	public Announce registerAnnounce(Integer userCode, String isbn, String description)
			throws UserNotFoundException, BookNotFoundException {
		User user = userRepositoryService.findById(userCode);
		Book book = bookRepositoryService.findById(isbn);
		description = description == null ? "" : description;
		
		AnnouncePK pk = new AnnouncePK(user.getCode(), book.getIsbn());
		Announce announce = new Announce(pk);
		announce.setDescription(description);
		announce.setSold(false);
		announce.setBook(book);
		
		announce = announceRepository.save(announce);
		return announce;
	}
}
