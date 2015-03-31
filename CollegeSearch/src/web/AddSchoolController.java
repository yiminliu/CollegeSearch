package web;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.SimpleFormController;

import service.CreateSchoolService;
import domain.School;
import domain.SchoolValidator;

@Controller
@RequestMapping("/addSchoolForm")
@SessionAttributes("school")
public class AddSchoolController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private CreateSchoolService service;
	private SchoolValidator schoolValidator;

	private Long schoolId;

	public AddSchoolController() {
	}

	// @Inject
	@Autowired
	public AddSchoolController(CreateSchoolService service,
			SchoolValidator schoolValidator) {
		this.service = service;
		this.schoolValidator = schoolValidator;
	}

	// @RequestMapping(value = "/addSchool", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) throws ServletException {
		// public ModelAndView addSchool() throws ServletException {

		School school = new School();
		System.out.println("addschool get called");
		model.addAttribute(school);

		return "addSchoolForm";
		// return new ModelAndView("addSchoolForm", "school", new School());
	}

	// @RequestMapping(value = "/addSchoolForm", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@ModelAttribute("school") School school,
			BindingResult result, Model model, SessionStatus status) {
		// System.out.println("adding school:" + school.getName());

		schoolValidator.validate(school, result);

		if (result.hasErrors()) {
			model.addAttribute(school);
			return "addSchoolForm";
		}

		schoolId = service.createSchool(school);
		logger.debug("added school");

		status.setComplete();

		return "redirect:addSchoolSuccess";
	}
}
