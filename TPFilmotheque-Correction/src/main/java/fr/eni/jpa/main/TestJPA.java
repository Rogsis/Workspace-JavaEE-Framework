package fr.eni.jpa.main;

import java.util.Iterator;
import java.util.List;

import fr.eni.jpa.bean.Acteur;
import fr.eni.jpa.bean.Film;
import fr.eni.jpa.bean.Realisateur;
import fr.eni.jpa.bean.Style;
import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.dao.GenericDao;
import fr.eni.jpa.dao.GenericDaoImpl;
import fr.eni.jpa.dao.GenericDaoImplFilm;

public class TestJPA {

	public static void main(String[] args) {
		
		//DAOUtil.getEntityManager();

		Style style1 = new Style("Comédie");
		Style style2 = new Style("Science-Fiction");
		
		GenericDao<Style, Integer> daoStyle = new GenericDaoImpl<>(Style.class);
		
		daoStyle.ajouter(style1);
		daoStyle.ajouter(style2);
		
		System.out.println("###### " + style1);
		System.out.println("###### " + style2);
		/*List<Style> styles = daoStyle.getAll();
		for(Style s :styles)
		{
			System.out.println(s);
		}*/
		
		Film film = new Film();
		film.setAnnee(1978);
		film.setTitre("Star Wars");
		film.setDuree(256);
		film.setVu(true);
		film.setStyle(style2);
		System.out.println("###### " + style2);
		film.setSynopsis("A long time ago eand a faraway galaxy");

		Acteur acteur1 = new Acteur("HAMILL", "Mark");
		Acteur acteur2 = new Acteur("FISHER", "Carrie");
		Acteur acteur3 = new Acteur("FORD", "Harrison");
		
		
		film.getActeurs().add(acteur1);
		film.getActeurs().add(acteur2);
		film.getActeurs().add(acteur3);
		
		
		Realisateur realisateur = new Realisateur("LUCAS", "George");
		film.setReal(realisateur);
		
		GenericDao<Film, Integer> daoFilm = new GenericDaoImplFilm();
		daoFilm.ajouter(film);
		
		Film filmAjoute = daoFilm.get(1);
		System.out.println(filmAjoute);
		System.out.println("###### " + realisateur);
		
		
		
		Film film2 = new Film();
		film2.setAnnee(1981);
		film2.setTitre("Star Wars 5");
		film2.setDuree(256);
		film2.setVu(true);
		film2.setStyle(style2);
		System.out.println("###### " + style2);
		
		film2.setSynopsis("La suite");

		for(Acteur a : filmAjoute.getActeurs())
		{
			film2.getActeurs().add(a);
		}
		
		film2.setReal(filmAjoute.getReal());
		
		daoFilm.ajouter(film2);
		
		Film filmAjoute2 = daoFilm.get(2);
		
		System.out.println(filmAjoute2);
		
		DAOUtil.close();
	}

}

