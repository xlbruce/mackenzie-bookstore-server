package exception;

public class InvalidPasswordException extends UserException {

	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String msg) {
		super(msg);
	}
}
