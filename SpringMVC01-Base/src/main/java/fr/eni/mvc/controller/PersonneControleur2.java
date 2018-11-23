package fr.eni.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import fr.eni.mvc.bean.Adresse;
import fr.eni.mvc.bean.Personne;

@Controller
@RequestMapping(path="/personnes2")
public class PersonneControleur2 {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView afficherAjoutPersonne()
	{
		return new ModelAndView("formulaireAjout2",
								/*"command"*/"personne", 
								new Personne("nom defaut", "prenom defaut", new Adresse("rennes")));
	}
	
	@RequestMapping(method=RequestMethod.POST)
//	public ModelAndView ajouterPersonne(String nom,
//										String prenom)
	public ModelAndView ajouterPersonne(Personne p)
	{
		return new ModelAndView("pagePersonne", "personne", p);
	}
}








