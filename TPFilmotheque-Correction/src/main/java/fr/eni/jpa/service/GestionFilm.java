package fr.eni.jpa.service;

import java.util.List;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.dao.GenericDaoImplFilm;

public class GestionFilm {

	private GenericDaoImplFilm daoFilm;
	
	public GestionFilm() {
		daoFilm =new GenericDaoImplFilm();
	}
	
	public List<Film> getListe() {
		return daoFilm.getAll();
	}

	public Film getFilm(int idFilmAAfficher) {
		return daoFilm.get(idFilmAAfficher);
	}

}
