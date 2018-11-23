package fr.eni.jpa.dao;

import java.util.List;

import fr.eni.jpa.exception.PersistanceException;

public interface GenericDao<TEntity,PKEntity> {

	/**
	 * @exception PersistanceException
	 */
	public void ajouter(TEntity entite);
	/**
	 * @exception PersistanceException
	 */
	public void modifier(TEntity entite);
	/**
	 * @exception PersistanceException
	 */
	public void supprimer(TEntity entite);
	/**
	 * @exception PersistanceException
	 */
	public void supprimerParPK(PKEntity pk);
	/**
	 * @exception PersistanceException
	 */
	public TEntity get(PKEntity pk);
	/**
	 * @exception PersistanceException
	 */
	public List<TEntity> getAll();
}
