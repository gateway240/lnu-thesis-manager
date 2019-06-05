package se.lnu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import se.lnu.form.UserForm;
import se.lnu.service.UserService;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Component
public class SignupValidator implements Validator{
	 @Autowired
	 UserService userService;
	 
	 private Pattern pattern;
	 private Matcher matcher;
	 private static final String PASSWORD_REGEX =
	          "^(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z]).{10}$";
	 

	 public boolean supports(Class<?> clazz) {
		 return UserForm.class.isAssignableFrom(clazz);
	 }

	 public void validate(Object target, Errors errors) {
		  UserForm user = (UserForm) target;
		  pattern = Pattern.compile(PASSWORD_REGEX);
		  
		  ValidationUtils.rejectIfEmpty(errors, "firstname", "notEmpty.firstname");
		  ValidationUtils.rejectIfEmpty(errors, "lastname", "notEmpty.lastname");
		  ValidationUtils.rejectIfEmpty(errors, "username", "notEmpty.username");
		  ValidationUtils.rejectIfEmpty(errors, "email", "notEmpty.email");
		  ValidationUtils.rejectIfEmpty(errors, "password", "notEmpty.password");
		  ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "notEmpty.confirmPassword");
		  
		  matcher = pattern.matcher(user.getPassword());
		  
		  if (!matcher.matches()) {
			  errors.rejectValue("password", "field.invalid");
		  }
	  
		  if(user.getPassword() != null && user.getConfirmPassword() != null && !user.getPassword().equals(user.getConfirmPassword())){
			  errors.rejectValue("password", "notMatch.confirmPassword");
		  }
		  
		  if(userService.userExists(user.getUsername())){
			  errors.rejectValue("username", "exists.username");
		  }
	 }
}
