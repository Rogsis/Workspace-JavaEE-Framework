package fr.eni.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eni.jpa.entity.User;

public class TestUser {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLSERVER_UP");
		EntityManager em = emf.createEntityManager();

		User u1 = new User(1, "user1", "password");
		User u2 = new User(2, "user2", "password");
		User u3 = new User(3, "user3", "password");

		em.getTransaction().begin();
		try {
			em.persist(u1);
			em.persist(u2);
			em.persist(u3);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		String requete = "from User";

		List<User> listeU;
		try {
			listeU = em.createQuery(requete).getResultList();
			System.out.println("Liste des User :");
			for (User u : listeU) {
				System.out.println(u.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();

	}

}
