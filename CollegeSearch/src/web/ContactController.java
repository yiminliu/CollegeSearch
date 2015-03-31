package web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

	@Value("#{ messageSource.getMessage('admin.email',null,'en')}")
	private String email;

	@RequestMapping("/contact")
	public String courtReservation(Model model) {
		if (email == null)
			email = "yimin@hotmail.com";
		model.addAttribute("email", email);
		return "contact";
	}
}
