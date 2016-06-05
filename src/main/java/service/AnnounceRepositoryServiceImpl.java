package service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import exception.AnnounceNotFoundException;
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
	
	@Override
	public List<Announce> findAnnounceByBookName(String bookName) {
		List<Book> books = bookRepositoryService.findByName(bookName);
		Set<String> isbns = extractIsbnsFromBooks(books);
		List<Announce> announces = announceRepository.findByIsbns(isbns);
		return announces;
	}
	
	public Announce findById(AnnouncePK id) throws AnnounceNotFoundException {
		Announce announce = announceRepository.findOne(id);
		if (announce == null) {
			throw new AnnounceNotFoundException("Anuncio não encontrado");
		}
		
		return announce;
	}
	
	private static Set<String> extractIsbnsFromBooks(List<Book> books) {
		Objects.requireNonNull(books);
		Set<String> isbns = new HashSet<>();
		
		books.forEach(book -> isbns.add(book.getIsbn()));
		
		return isbns;
	}
}
