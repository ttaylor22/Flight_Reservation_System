package com.group.FRS.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.group.FRS.model.UserCredential;
import com.group.FRS.service.IUser_CredentialService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private IUser_CredentialService userCredentialService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return UserCredential.class.equals(aClass);
	}
	
	@Override
	public void validate(Object o, Errors errors) {
		UserCredential user = (UserCredential) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (userCredentialService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}
		
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}
}
