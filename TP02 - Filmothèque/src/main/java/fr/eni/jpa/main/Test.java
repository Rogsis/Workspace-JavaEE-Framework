package fr.eni.jpa.main;

import fr.eni.jpa.bean.Acteur;
import fr.eni.jpa.bean.Film;
import fr.eni.jpa.bean.Personne;
import fr.eni.jpa.bean.Realisateur;
import fr.eni.jpa.bean.Style;
import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.dao.GenericDaoImpl;
import fr.eni.jpa.dao.GenericDaoImplFilm;

public class Test {

	public static void main(String[] args) {
		GenericDaoImpl<Style> styleDAO = new GenericDaoImpl<Style>();
		GenericDaoImpl<Film> filmDAO = new GenericDaoImplFilm();
		Style s1= new Style("Policier");
		Style s2= new Style("Comique");
		Style s3= new Style("Fantastique");
		
		Acteur a1 = new Acteur("Jean","Gabin");
		Acteur a2 = new Acteur("Emma","Watson");
		
		Realisateur r1 = new Realisateur("Peter","Jackson");
		Realisateur r2 = new Realisateur("Chris","Colombus");
		
		Film f1 = new Film ("Le Seigneur des Anneaux","2001",s3,"2:05",true,"Un anneau pour les rassembler tous...",r1);
		Film f2 = new Film ("Harry Potter","2001",s3,"2:05",true,"Chosen one",r2);
		
		f1.getActeurs().add(a1);
		f1.getActeurs().add(a2);
		f2.getActeurs().add(a2);
		
		
		try {
			styleDAO.save(s1);
			styleDAO.save(s2);
			styleDAO.save(s3);
			System.out.println("les Styles : ");
			for(Style s : styleDAO.list(Style.class)) {
				System.out.println(s);
			}
			/*Realisateur realE = realisateurDAO.get(Realisateur.class,r1.getId());
			System.out.println("Real enregistré : " + realE.toString());*/
			filmDAO.save(f1);
			filmDAO.save(f2);
			Film filmE = filmDAO.get(Film.class,1);
			Film filmE2 = filmDAO.get(Film.class,2);
			System.out.println("Film enregistré : " + filmE.toString() + "\n" + filmE2.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAOUtil.close();
		//List<Style> styleEn = genericDaoImpl.list(Style.class);

	}

}
