package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exception.BookNotFoundException;
import exception.UserNotFoundException;
import model.entities.Announce;
import service.AnnounceRepositoryService;

@RestController
@RequestMapping("/announces")
public class AnnounceController {

	@Autowired
	private AnnounceRepositoryService announceRpositoryService;

	@RequestMapping(method = RequestMethod.POST)
	public Announce registerAnnounce(@RequestParam("user_code") Integer code, @RequestParam("isbn") String isbn,
			@RequestParam("description") String description) throws UserNotFoundException, BookNotFoundException {

		return announceRpositoryService.registerAnnounce(code, isbn, description);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Announce> findAnnouncesByBookName(@RequestParam("book_name") String bookName) {
		List<Announce> announces = announceRpositoryService.findAnnounceByBookName(bookName);
		
		return announces;
	}

}
