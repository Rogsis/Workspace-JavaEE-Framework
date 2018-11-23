package fr.eni.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import fr.eni.jpa.exception.PersistanceException;

public class GenericDaoImpl<TEntity, PKEntity> implements GenericDao<TEntity, PKEntity> {

	private Class<TEntity> typeManipule;
	
	
	public GenericDaoImpl(Class<TEntity> typeManipule) {
		super();
		this.typeManipule = typeManipule;
	}

	/**
	 * @exception PersistanceException
	 */
	@Override
	public void ajouter(TEntity entite) {
		EntityManager em = DAOUtil.getEntityManager();
		try
		{
			em.getTransaction().begin();
			//...
			em.persist(entite);
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

	@Override
	public void modifier(TEntity entite) {
		EntityManager em = DAOUtil.getEntityManager();
		try
		{
			em.getTransaction().begin();
			//...
			em.merge(entite);
			em.getTransaction().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new PersistanceException();
		}
		finally
		{
			em.close();
		}
	}

	@Override
	public void supprimer(TEntity entite) {
		EntityManager em = DAOUtil.getEntityManager();
		try
		{
			em.getTransaction().begin();
			//...
			em.remove(em.merge(entite));
			em.getTransaction().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new PersistanceException();
		}
		finally
		{
			em.close();
		}
	}

	@Override
	public void supprimerParPK(PKEntity pk) {
		this.supprimer(this.get(pk));
	}

	@Override
	public TEntity get(PKEntity pk) {
		TEntity entite = null;
		EntityManager em = DAOUtil.getEntityManager();
		try
		{
			entite = em.find(typeManipule, pk);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new PersistanceException();
		}
		finally
		{
			em.close();
		}
		return entite;
	}

	@Override
	public List<TEntity> getAll() {
		List<TEntity> entites = null;
		EntityManager em = DAOUtil.getEntityManager();
		try
		{
			entites = em.createQuery("from "+typeManipule.getSimpleName()).getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new PersistanceException();
		}
		finally
		{
			em.close();
		}
		return entites;
	}

}
