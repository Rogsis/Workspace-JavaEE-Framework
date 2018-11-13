package fr.eni.jpa.main;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eni.jpa.entity.Personne;

public class TestPersonne {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLSERVER_UP");
		EntityManager em = emf.createEntityManager();

		Personne p1 = new Personne("Legrand","Lucie", new GregorianCalendar(1992,1,24));

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
		
		String requete = "select p from Personne p";

		Personne pEnregistre;
		try {
			pEnregistre = (Personne) em.createQuery(requete).getSingleResult();
			System.out.println("Personne enregistrée : " + pEnregistre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();

	}

}
