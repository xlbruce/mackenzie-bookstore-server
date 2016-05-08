package exception;

public class UsernameAlreadyTakenException extends UserException {

	private static final long serialVersionUID = 1L;

	public UsernameAlreadyTakenException(String msg) {
		super(msg);
	}
}
