package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exception.TiaNotValidException;
import model.response.ResponseCode;

@RestController
@RequestMapping(path = "/register")
public class RegisterController {

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseCode register(@RequestParam(value = "userCode") String userCode,
			@RequestParam(value = "email") String email, 
			@RequestParam(value = "password") String password) throws TiaNotValidException {
		if (!validate(userCode)) {
			throw new TiaNotValidException("TIA/DRT inválido");
		}
		
		//TODO 
		/*
		 * If a user already exists, then it must throw a UserAlreadyExistsException.
		 */
		if (userCode.equals("1234") && email.equals("email@teste.com") && password.equals("1234")) {
			return ResponseCode.userRegistered();
		}
		return ResponseCode.userAlreadyRegistered();
	}
	
	
	private boolean validate(String userCode) {
		final byte[] nums = {8, 7, 6, 5, 4, 3, 2};
		
		int tia = Integer.parseInt(userCode);
        int lastDigit = tia % 10;
        tia /= 10;
        int remainder;
        int sum = 0;
        int i = 6; //Iterate from right to left
        
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
