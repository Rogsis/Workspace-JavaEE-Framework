package fr.eni.mvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.eni.mvc.bean.Acteur;
import fr.eni.mvc.bean.Film;
import fr.eni.mvc.bean.Realisateur;
import fr.eni.mvc.bean.Style;
import fr.eni.mvc.dao.ActeurDAO;
import fr.eni.mvc.dao.FilmDAO;
import fr.eni.mvc.dao.RealisateurDAO;

@Service(value="gestionFilm")
public class GestionFilm {

	@Resource(name="filmDAO")
	private FilmDAO filmDAO;
	
	@Resource(name="realisateurDAO")
	private RealisateurDAO realisateurDAO;

	@Resource(name="acteurDAO")
	private ActeurDAO acteurDAO;
	
	
	public List<Film> getFilms()
	{
		//return this.filmDAO.findAll();
		return this.filmDAO.getFilmsAvecStyleEtRealisateur();
	}

	public void supprimer(int id) {
		this.filmDAO.delete(id);
		
	}

	public Object getFilm(int id) {
		return this.filmDAO.getFilmById(id);
	}

	public void enregistrer(Film film) {
		//Vérifier si le réalisateur est déjà en base (par son nom et prenom). Sinon, l'enregistrer
		Realisateur real = this.realisateurDAO.findByNomAndPrenom(film.getReal().getNom(),film.getReal().getPrenom());
		if(real==null)
		{
			real = this.realisateurDAO.save(film.getReal());
		}
		film.setReal(real);
		
		List<Acteur> acteursManages = new ArrayList<Acteur>();
		for(Acteur acteur : film.getActeurs())
		{
			Acteur acteurManage = this.acteurDAO.findByNomAndPrenom(acteur.getNom(), acteur.getPrenom());
			if(acteurManage==null)
			{
				acteurManage = this.acteurDAO.save(acteur);
			}
			acteursManages.add(acteurManage);
		}
		film.setActeurs(acteursManages);
		
		this.filmDAO.save(film);
		
	}

	
	
}






