package controller;

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

import exception.InvalidPasswordException;
import exception.UserException;
import exception.UserNotFoundException;
import model.entities.User;
import model.entities.UserType;
import service.UserRepositoryService;

@RestController
public class UserController {

	@Autowired
	private UserRepositoryService userRepositoryService;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public User registerNewUser(@RequestParam("userCode") Integer userCode, @RequestParam("username") String username,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("typeId") Integer typeId) throws UserException {
		UserType userType = new UserType(typeId);

		User user = new User();
		user.setCode(userCode);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setUserType(userType);

		return userRepositoryService.register(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public User login(@RequestParam("code") Integer code,
					  @RequestParam("password") String password)
			throws UserNotFoundException, InvalidPasswordException {
		return userRepositoryService.login(code, password);
	}
	
	@RequestMapping(path = "/user/{userCode}", method = RequestMethod.GET)
	public User findByid(@PathVariable("userCode") Integer userCode) throws UserNotFoundException {
		return userRepositoryService.findById(userCode);
	}

	@ExceptionHandler(UserException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String processErrors(UserException ex) {
		return ex.getMessage();
	}
}
