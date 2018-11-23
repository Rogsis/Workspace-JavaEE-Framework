package fr.eni.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bean.Acteur;
import fr.eni.mvc.bean.Film;
import fr.eni.mvc.bean.Realisateur;
import fr.eni.mvc.service.GestionFilm;
import fr.eni.mvc.service.GestionStyle;

@Controller
public class FilmControleur {
	@Resource(name="gestionFilm")
	private GestionFilm gestionFilm;

	
	@Resource(name="gestionStyle")
	private GestionStyle gestionStyle;
	
	@RequestMapping(method=RequestMethod.GET, path="/lister")
	public ModelAndView afficherFilms()
	{
		ModelAndView mav = new ModelAndView("listeFilms",
											"listeF",
											this.gestionFilm.getFilms());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/afficher")
	public ModelAndView afficherFilm(int id)
	{
		ModelAndView mav = new ModelAndView("afficherFilm",
											"film",
											this.gestionFilm.getFilm(id));
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/editer")
	public ModelAndView editerFilm(int id)
	{
		ModelAndView mav = new ModelAndView("editerFilm",
											"film",
											this.gestionFilm.getFilm(id));
		mav.addObject("listeStyles", this.gestionStyle.getStyles());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/editer")
	public String modifierFilm(@ModelAttribute("film") Film film)
	{
		//J'enlève toutes les entrées inutiles
		for(int i = film.getActeurs().size()-1;i>=0;i--)
		{
			if(film.getActeurs().get(i).getNom().trim().equals("") &&
				film.getActeurs().get(i).getPrenom().trim().equals(""))
			{
				film.getActeurs().remove(i);
			}
		}
		//Modifier le film et éventuellement les objets liés
		this.gestionFilm.enregistrer(film);
		//Je refraichis l'objet Style pour avoir le libellé de celui-ci.
		film.setStyle(this.gestionStyle.getStyle(film.getStyle().getId()));
		return "afficherFilm";
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/supprimer")
	public ModelAndView supprimerFilm(int id)
	{
		this.gestionFilm.supprimer(id);
		return afficherFilms();//mais un redirect est préférable
	}

	@RequestMapping(method=RequestMethod.GET,path="/ajouter")
	public ModelAndView afficherFormulaireAjout()
	{
		Film film = new Film();
		/*List<Acteur> acteurs = new ArrayList<Acteur>();
		for(int i=0;i<5;i++)
		{
			acteurs.add(new Acteur());
		}
		film.setActeurs(acteurs);*/
		ModelAndView mav = new ModelAndView("ajouterFilm", "film", film);
		mav.addObject("listeStyles", this.gestionStyle.getStyles());
		return mav;
	}
	@RequestMapping(method=RequestMethod.POST,path="/ajouter")
	public String ajouterFilm(Film film)
	{
		//J'enlève toutes les entrées inutiles
		for(int i = film.getActeurs().size()-1;i>=0;i--)
		{
			if(film.getActeurs().get(i).getNom().trim().equals("") &&
				film.getActeurs().get(i).getPrenom().trim().equals(""))
			{
				film.getActeurs().remove(i);
			}
		}
		this.gestionFilm.enregistrer(film);
		return "redirect:lister";
	}
}








