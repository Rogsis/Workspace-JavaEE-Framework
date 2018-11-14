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
		Adresse a1 = new Adresse("Rennes");
		Adresse a2 = new Adresse("Paris");

		p1.getAdresse().add(a1);
		p1.getAdresse().add(a2);
		System.out.println("p1 avant enregistrement : " + p1);
		
		em.getTransaction().begin();
		try {
			em.persist(p1);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		System.out.println("p1 arès enregistrement : " + p1);
		

		try {
			Personne pEnregistre = em.find(Personne.class,p1.getId());
			System.out.println("Personne enregistrée : " + pEnregistre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();

	}

}
