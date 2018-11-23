package fr.eni.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccueilController {

	@RequestMapping(method = RequestMethod.GET, path = "/accueil")
	public String afficherAccueil() {
		return "index";
	}
}
