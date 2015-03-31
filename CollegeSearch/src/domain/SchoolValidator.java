package domain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SchoolValidator implements Validator {

	String name;

	public boolean supports(Class clazz) {
		return School.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.schoolName", "School name is required.");

		if (name.length() < 2 || name.length() > 22) {
			errors.reject("invalid.schoolName", "Invalid school name.");
		}
	}
}