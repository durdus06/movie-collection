package durdu.projects.moviecollection.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import durdu.projects.moviecollection.model.User;
import durdu.projects.moviecollection.service.impl.UserDetailsServiceImpl;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, String> {
	@Autowired
	private UserDetailsServiceImpl userService;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		Optional<User> user = userService.findUserByEmail(email);
		if (user.isPresent()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void initialize(UniqueEmail constraintAnnotation) {

	}
}
