package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RetrieveSchoolValidator implements Validator {
	private int DEFAULT_MIN_PERCENTAGE = 0;
	private int DEFAULT_MAX_PERCENTAGE = 50;
	private int minPercentage = DEFAULT_MIN_PERCENTAGE;
	private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	public boolean supports(Class clazz) {
		return RetrieveSchool.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		RetrieveSchool rs = (RetrieveSchool) obj;
		if (rs == null) {
			errors.rejectValue("rank", "error.not-specified", null,
					"Value required.");
		}
	}

}