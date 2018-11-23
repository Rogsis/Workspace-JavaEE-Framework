package fr.eni.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import fr.eni.mvc.bean.Personne;

@Controller
@RequestMapping(path="/personnes")
public class PersonneControleur {

	@RequestMapping(method=RequestMethod.GET)
	public String afficherAjoutPersonne()
	{
		return "formulaireAjout";
	}
	
	@RequestMapping(method=RequestMethod.POST)
//	public ModelAndView ajouterPersonne(String nom,
//										String prenom)
	public ModelAndView ajouterPersonne(Personne p)
	{
		return new ModelAndView("pagePersonne", "personne", p);
	}
}








