package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.response.ResponseCode;

@RestController
public class LoginController {

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	@ResponseBody
	public ResponseCode authenticate(@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password) {
		if (login.equals("admin") && password.equals("admin")) {
			return ResponseCode.loginOk();
		}
		return ResponseCode.loginFail();
	}
}
