package fr.eni.jpa.main;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eni.jpa.entity.Adresse;
import fr.eni.jpa.entity.Personne;

public class TestPersonne {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLSERVER_UP");
		EntityManager em = emf.createEntityManager();

		Personne p1 = new Personne("Legrand","Lucie", new GregorianCalendar(1992,1,24));
		Personne p2 = new Personne("Dupond","Roger", new GregorianCalendar(1985,5,20));
		Adresse a1 = new Adresse("Rennes");
		Adresse a2 = new Adresse("Paris");
		Adresse a3 = new Adresse("Lyon");

		p1.getAdresse().add(a1);
		p1.getAdresse().add(a3);
		p2.getAdresse().add(a2);
		p2.getAdresse().add(a1);
		
		em.getTransaction().begin();
		try {
			em.persist(p1);
			em.persist(p2);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		

		try {
			Adresse aEnregistre = em.find(Adresse.class, a1.getId());
			Adresse aEnregistre2 = em.find(Adresse.class, a2.getId());
			Adresse aEnregistre3 = em.find(Adresse.class, a3.getId());
			Personne pEnregistre = em.find(Personne.class,p1.getId());
			Personne pEnregistre2 = em.find(Personne.class,p2.getId());
			System.out.println("Adresse enregistrée : " + aEnregistre + "\n" + aEnregistre2 + "\n" + aEnregistre3);
			System.out.println("Personne enregistrée : " + pEnregistre + "\n" + pEnregistre2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();

	}

}
