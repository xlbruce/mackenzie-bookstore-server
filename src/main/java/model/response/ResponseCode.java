package model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class ResponseCode implements Serializable {
	//TODO
	/*LOGINOK("200", "OK"),
	LOGINFAIL("400", "Username or password are incorrect"),
	REGISTERED("204", "User registered"),
	USERALREADYEXISTS("400", "User already exists")*/
	;
	
	private static final long serialVersionUID = 1L;

	private int code;
	
	private String message;
	
	public ResponseCode() {
	}
	
	private ResponseCode (final int code, final String message) {
		this.code = code;
		this.message = message;
	}
	
	public static ResponseCode loginOk() {
		return new ResponseCode(200, "OK");
	}
	
	public static ResponseCode loginFail() {
		return new ResponseCode(400, "Username or password are incorrect");
	}
	
	public static ResponseCode userRegistered() {
		return new ResponseCode(204, "User registered");
	}
	
	public static ResponseCode userAlreadyRegistered() {
		return new ResponseCode(400, "User already exists");
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() { 
		return message;
	}

}
