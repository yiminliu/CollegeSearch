package web;

import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.RetrieveSchoolService;
import domain.School;
import domain.SchoolValidator;

@Controller
@Scope("request")
public class GetSchoolController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private RetrieveSchoolService service;
	private SchoolValidator schoolValidator;

	private List<School> schools;

	public GetSchoolController() {
	}

	// @Inject
	@Autowired
	public GetSchoolController(RetrieveSchoolService service,
			SchoolValidator schoolValidator) {
		this.service = service;
		this.schoolValidator = schoolValidator;
	}

	@RequestMapping(value = "/listTopSchools", method = RequestMethod.POST)
	public ModelAndView listTopTopSchools(@RequestParam("rank") int rank)
	// public ModelAndView listTopTopSchools(int rank)

			throws ServletException {

		System.out.println("listTopTopSchools, post");
		schools = service.getTopSchools(rank);
		System.out.println("schools size: " + schools.size());

		return new ModelAndView("retrieveSchool", "schools", schools);
	}

	@RequestMapping(value = "/getSchoolDetail", method = RequestMethod.POST)
	public String getSchoolDetail(
			@RequestParam("schoolName") String schoolName, Model model,
			BindingResult result) throws ServletException {

		schoolValidator.validate(schoolName, result);

		if (result.hasErrors())
			return "addSchoolForm";

		logger.debug("getSchoolDetail, post");

		School school = service.getSchoolByName(schoolName);

		if (school != null)
			logger.debug("getSchoolDetail, school retrieved: "
					+ school.getName());

		// schools.add(school);
		model.addAttribute(school);

		return "retrieveSchool2";

	}

	@RequestMapping(value = "/listAllSchools", method = RequestMethod.GET)
	public ModelAndView listAllTopSchools() throws ServletException {

		schools = service.getAllSchools();
		System.out.println("schools size: " + schools.size());

		return new ModelAndView("retrieveSchool", "schools", schools);
	}

}
