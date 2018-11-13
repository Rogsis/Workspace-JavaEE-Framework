package fr.eni.jpa.main;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eni.jpa.entity.Personne;
import fr.eni.jpa.entity.PersonnePK;

public class TestPersonne {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLSERVER_UP");
		EntityManager em = emf.createEntityManager();

		Personne p1 = new Personne("Legrand","Lucie", new GregorianCalendar(1992,1,24));
		Personne p2 = new Personne("Gouin","Paul", new GregorianCalendar(1965,1,24));
		
		em.getTransaction().begin();
		try {
			em.persist(p1);
			em.persist(p2);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		String requete = "select p from Personne p";

		Personne p = em.find(Personne.class, new PersonnePK("Gouin","Paul"));
		System.out.println("personne récupérée = " + p);
		/*Personne pEnregistre;
		try {
			pEnregistre = (Personne) em.createQuery(requete).getSingleResult();
			System.out.println("Personne enregistrée : " + pEnregistre);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		em.close();
		emf.close();

	}

}
