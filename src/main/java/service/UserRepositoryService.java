package service;

import exception.InvalidPasswordException;
import exception.TiaNotValidException;
import exception.UserAlreadyRegisteredException;
import exception.UserNotFoundException;
import exception.UsernameAlreadyTakenException;
import model.entities.User;

public interface UserRepositoryService {

	User register(User user) throws TiaNotValidException, UserAlreadyRegisteredException, UsernameAlreadyTakenException;

	User login(Integer code, String password) throws UserNotFoundException, InvalidPasswordException;

}
