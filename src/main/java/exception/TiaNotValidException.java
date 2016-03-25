package exception;

public class TiaNotValidException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TiaNotValidException() {
	}
	
	public TiaNotValidException(String msg) {
		super(msg);
	}

}
