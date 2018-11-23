package fr.eni.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.eni.spring.bean.Film;
import fr.eni.spring.dao.FilmRepository;

@Service(value="gestionFilm")
public class GestionFilm {

	@Resource(name="filmDAO")
	private FilmRepository fRep;
	
	public List<Film> getListe()
	{
		return fRep.findAll();
	}
	
	public void ajouter(Film filmAAjouter) {
		//Vérifier éventuellement auparavant la 
		//bonne saisie des informations
		//....
		fRep.save(filmAAjouter);
	}

	public void supprimer(int idFilmASupprimer) {
		fRep.delete(idFilmASupprimer);
	}

	public void modifier(int idFilmAModifier, Film FilmAModifier) {
		FilmAModifier.setId(idFilmAModifier);
		
		fRep.save(FilmAModifier);
		
	}
}
