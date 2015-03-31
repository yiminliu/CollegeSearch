package web;

import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.DeleteSchoolService;
import domain.School;

@Controller
// @RequestMapping("/school")
public class DeleteSchoolController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private DeleteSchoolService service;

	private List<School> schools;

	public DeleteSchoolController() {
	}

	@Autowired
	public DeleteSchoolController(DeleteSchoolService service) {
		this.service = service;
	}

	@RequestMapping(value = { "/delete", "/remove" }, method = RequestMethod.GET)
	public String setupDeleteSchool(Model model) throws ServletException {

		System.out.println("setupDelete, post");
		School school = new School();
		model.addAttribute(school);

		return "deleteSchool";
	}

	@RequestMapping(value = { "/deleteForm", "/removeForm", "deleteSchool",
			"removeSchool" }, method = RequestMethod.GET)
	public String deleteByName(@RequestParam("schoolName") String schoolName,
			Model model) throws ServletException {

		System.out.println("deleteByName, post");
		service.deleteSchoolByName(schoolName);
		model.addAttribute(schoolName);
		System.out.println("schools deleted: " + schoolName);

		return "deleteSuccess";
	}

}
