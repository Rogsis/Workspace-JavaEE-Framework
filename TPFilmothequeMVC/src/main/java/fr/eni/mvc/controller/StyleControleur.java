package fr.eni.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.mvc.bean.Style;
import fr.eni.mvc.service.GestionStyle;

@Controller
public class StyleControleur {

	@Resource(name="gestionStyle")
	private GestionStyle gestionStyle;
	
	@RequestMapping(path="/listerStyle", method=RequestMethod.GET)
	public String afficherStyles(ModelMap map)
	{
		map.addAttribute("listeS", gestionStyle.getStyles());
		return "listeStyles";
	}
	
	@RequestMapping(path= {"/ajouterStyle","/modifStyle"}, method=RequestMethod.POST)
	public String enregistrerStyle(Style style)
	{
		this.gestionStyle.enregistrer(style);
		return "redirect:listerStyle";
	}
	
	@RequestMapping(path="/supprimerStyle", method=RequestMethod.GET)
	public String supprimerStyle(@RequestParam(name="index") int id)
	{
		this.gestionStyle.supprimer(id);
		return "redirect:listerStyle";
	}
}







