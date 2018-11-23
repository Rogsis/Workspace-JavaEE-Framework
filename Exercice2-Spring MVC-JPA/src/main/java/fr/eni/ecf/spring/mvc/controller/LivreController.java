

package fr.eni.ecf.spring.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.ecf.spring.mvc.bean.Livre;
import fr.eni.ecf.spring.mvc.service.LivreService;

@Controller(value="livreController")
public class LivreController {
	
	@Resource(name="livreService")
	private LivreService livreService;

	
	@RequestMapping(path="/lister", method=RequestMethod.GET)
	public String afficherLivres(ModelMap map)
	{
		map.addAttribute("listeL", this.livreService.getLivres());
		return "listeLivres";
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/ajouter")
	public ModelAndView afficherFormulaireAjout()
	{
		Livre livre = new Livre();
		ModelAndView mav = new ModelAndView("ajouterLivre", "livre", livre);
		return mav;
	}
	
	@RequestMapping(path= {"/ajouter"}, method=RequestMethod.POST)
	public String enregistrerLivre(Livre livre)
	{
		this.livreService.enregistrer(livre);
		return "redirect:lister";
	}
	
	@RequestMapping(path="/supprimerLivre", method=RequestMethod.GET)
	public String supprimerLivre(@RequestParam(name="isbn") String isbn)
	{
		this.livreService.supprimer(isbn);
		return "redirect:lister";
	}
}
