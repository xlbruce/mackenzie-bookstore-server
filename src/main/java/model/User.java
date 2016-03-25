package model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String code;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	public User() {
	}
	
	public User(String code, String email, String password) {
		this.setCode(code);
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
