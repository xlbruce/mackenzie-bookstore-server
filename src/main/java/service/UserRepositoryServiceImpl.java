package service;

import org.springframework.beans.factory.annotation.Autowired;

import exception.InvalidPasswordException;
import exception.TiaNotValidException;
import exception.UserAlreadyRegisteredException;
import exception.UserNotFoundException;
import exception.UsernameAlreadyTakenException;
import model.entities.User;
import model.entities.UserType;
import repository.UserRepository;
import repository.UserTypeRepository;

public class UserRepositoryServiceImpl implements UserRepositoryService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserTypeRepository userTypeRepository;

	public UserRepositoryServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
		this.userRepository = userRepository;
		this.userTypeRepository = userTypeRepository;
	}

	@Override
	public User register(User user)
			throws TiaNotValidException, UserAlreadyRegisteredException, UsernameAlreadyTakenException {
		if (!validate(user.getCode().toString())) {
			throw new TiaNotValidException("Tia inválido");
		}

		if (userRepository.exists(user.getCode())) {
			throw new UserAlreadyRegisteredException("Usuário já cadastrado");
		}

		if (findByUsername(user.getUsername()) != null) {
			throw new UsernameAlreadyTakenException("Nome de usuário já está em uso");
		}

		User registeredUser = save(user);
		return registeredUser;
	}

	@Override
	public User login(Integer code, String password) throws UserNotFoundException, InvalidPasswordException {
		User user = userRepository.findOne(code);
		if (user == null) {
			throw new UserNotFoundException("Usuário não cadastrado");
		}
		if (!password.equals(user.getPassword())) {
			throw new InvalidPasswordException("Senha inválida");
		}
		
		return user;
	}

	private User findByUsername(String username) {
		return userRepository.findByUsername(username).stream().filter(u -> username.equals(u.getUsername()))
				.findFirst().orElse(null);
	}

	private User save(User user) {
		UserType userType = userTypeRepository.findOne(user.getUserType().getTypeId());
		user.setUserType(userType);

		User userSaved = userRepository.save(user);
		return userSaved;
	}

	private boolean validate(String userCode) {
		final byte[] nums = { 8, 7, 6, 5, 4, 3, 2 };

		int tia = Integer.parseInt(userCode);
		int lastDigit = tia % 10;
		tia /= 10;
		int remainder;
		int sum = 0;
		int i = 6; // Iterate from right to left

		while (tia > 0) {
			remainder = tia % 10;
			sum += (remainder * nums[i--]);
			tia /= 10;
		}
		remainder = sum % 11;
		int calculatedDigit = (remainder <= 1) ? remainder : (11 - remainder);
		return calculatedDigit == lastDigit;
	}
}
