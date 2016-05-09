package exception;

public class BookNotFoundException extends BookException {

	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String msg) {
		super(msg);
	}
}
