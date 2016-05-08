package service;

import exception.TiaNotValidException;
import exception.UserAlreadyRegisteredException;
import exception.UsernameAlreadyTakenException;
import model.entities.User;

public interface UserRepositoryService {

	User register(User user) throws TiaNotValidException, UserAlreadyRegisteredException, UsernameAlreadyTakenException;

}
