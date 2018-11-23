package fr.eni.jpa.dao;

import javax.persistence.EntityManager;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.exception.PersistanceException;

public class GenericDaoImplFilm extends GenericDaoImpl<Film, Integer> {

	public GenericDaoImplFilm() {
		super(Film.class);
	}

	@Override
	public void ajouter(Film entite) {
		
		EntityManager em = DAOUtil.getEntityManager();
		try
		{
			em.getTransaction().begin();
			//...
			//Le merge permet de détecter ce qu'il doit faire pour
			//les objets liés au film.
			em.persist(em.merge(entite));
			em.getTransaction().commit();
		}catch(Exception e)
		{
			//Attention pas idéal car je camoufle l'erreur.
			//L'appelant ne sait pas que ça s'est mal passé!!
			//CF. TP Livres
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new PersistanceException();
		}
		finally
		{
			em.close();
		}
	}
	
}
