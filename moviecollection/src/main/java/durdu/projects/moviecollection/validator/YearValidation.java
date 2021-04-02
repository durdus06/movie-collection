package durdu.projects.moviecollection.validator;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearValidation implements ConstraintValidator<Year, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// Year of the movie can be maximum 20 years later from current year, and it must be greater that 1850
		if (value > 1850 && value < (Calendar.getInstance().get(Calendar.YEAR) + 20)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void initialize(Year constraintAnnotation) {

	}

}
