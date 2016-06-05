package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exception.AnnounceNotFoundException;
import exception.BookNotFoundException;
import exception.UserNotFoundException;
import model.entities.Announce;
import model.entities.AnnouncePK;
import service.AnnounceRepositoryService;

@RestController
public class AnnounceController {

	@Autowired
	private AnnounceRepositoryService announceRepositoryService;

	@RequestMapping(path = "/announces", method = RequestMethod.POST)
	public Announce registerAnnounce(@RequestParam("user_code") Integer code, @RequestParam("isbn") String isbn,
			@RequestParam("description") String description) throws UserNotFoundException, BookNotFoundException {

		return announceRepositoryService.registerAnnounce(code, isbn, description);
	}

	@RequestMapping(path = "/announces", method = RequestMethod.GET)
	public List<Announce> findAnnouncesByBookName(@RequestParam("book_name") String bookName) {
		List<Announce> announces = announceRepositoryService.findAnnounceByBookName(bookName);

		return announces;
	}

	@RequestMapping(path = "/announce/{userCode}/{isbn}", method = RequestMethod.GET)
	public Announce findByPk(@PathVariable("userCode") Integer userCode, @PathVariable("isbn") String isbn)
			throws AnnounceNotFoundException {
		AnnouncePK id = new AnnouncePK(userCode, isbn);
		Announce announce = announceRepositoryService.findById(id);
		
		return announce;
	}
	
	@ExceptionHandler(AnnounceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String processErrors(AnnounceNotFoundException ex) {
		return ex.getMessage();
	}

}
