package exception;

public class UserAlreadyRegisteredException extends UserException {

	private static final long serialVersionUID = 1L;
	
    public UserAlreadyRegisteredException(String msg) {
    	super(msg);
	}

}
