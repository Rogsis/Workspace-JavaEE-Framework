package fr.eni.jpa.dao;

import javax.persistence.EntityManager;

import fr.eni.jpa.bean.Film;

public class GenericDaoImplFilm  extends GenericDaoImpl<Film>{

	public GenericDaoImplFilm() {
		super();
	}
	
	@Override
	public void save(Film entite) {
		
		EntityManager em = DAOUtil.getEntityManager();
		try
		{
			em.getTransaction().begin();
			//...
			em.persist(em.merge(entite));
			em.getTransaction().commit();
		}catch(Exception e)
		{
			//Attention pas idéal car je camoufle l'erreur.
			//L'appelant ne sait pas que ça s'est mal passé!!
			//CF. TP Livres
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		finally
		{
			em.close();
		}
	}
}
