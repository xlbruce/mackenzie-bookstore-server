package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exception.UserException;
import model.entities.User;
import model.entities.UserType;
import service.UserRepositoryService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepositoryService userRepositoryService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public User registerNewUser(@RequestParam("userCode") Integer userCode, 
								@RequestParam("username") String username,
								@RequestParam("email") String email, 
								@RequestParam("password") String password,
								@RequestParam("typeId") Integer typeId)
					throws UserException {
		UserType userType = new UserType(typeId);
		
		User user = new User();
		user.setCode(userCode);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setUserType(userType);

		return userRepositoryService.register(user);
	}
	
	@ExceptionHandler(UserException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String processErrors(UserException ex) {
		return ex.getMessage();
	}

}
