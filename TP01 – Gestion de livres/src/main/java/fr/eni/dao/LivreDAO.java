package fr.eni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.eni.bean.Livre;
import fr.eni.exception.DAOException;

public class LivreDAO {
	EntityManager em;
	

	public LivreDAO() {
		super();
		this.em = DAOUtil.getEntityManager();
	}

	public void add(Livre livre) throws DAOException {
		try {
			this.em.getTransaction().begin();
			this.em.persist(livre);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw new DAOException("Erreur à l'ajout d'un livre");
		}
	}
	
	public void delete(Livre livre) throws DAOException {
		try {
			this.em.getTransaction().begin();
			this.em.remove(livre);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw new DAOException("Erreur à la suppression d'un livre");
		}
	}
	
	public void update(Livre livre) throws DAOException {
		try {
			this.em.getTransaction().begin();
			this.em.merge(livre);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw new DAOException("Erreur à la modification d'un livre");
		}
	}
	
	public void delete (int id) throws DAOException {
		try {
			this.em.getTransaction().begin();
			this.em.remove(this.findById(id));
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw new DAOException("Erreur à la suppression d'un livre via son ID");
		}
		
	}
	
	public Livre findById(int val) throws DAOException {
		return this.em.find(Livre.class, val);
	}
	
	public List<Livre> findAll() throws DAOException {
		TypedQuery<Livre> query = this.em.createQuery("FROM Livre", Livre.class);
		return query.getResultList();
	}
	public List<Livre> findAllOrderByTitreAsc() throws DAOException {
		TypedQuery<Livre> query = this.em.createQuery("FROM Livre l ORDER BY l.titre ASC", Livre.class);
		return query.getResultList();
	}
	public List<Livre> findAllOrderByTitreDesc() throws DAOException {
		TypedQuery<Livre> query = this.em.createQuery("FROM Livre l ORDER BY l.titre DESC", Livre.class);
		return query.getResultList();
	}
	
	public List<Livre> findByAuteur(String auteur) throws DAOException {
		TypedQuery<Livre> query = this.em.createQuery("FROM Livre l WHERE l.auteur like :auteur", Livre.class);
		query.setParameter("auteur", "%"+auteur+"%");
		return query.getResultList();
	}
	
	public int getMaxId() throws DAOException {
		return (int) this.em.createQuery("SELECT max(l.id) from Livre l").getSingleResult();
	}
	
	public int getMinId() throws DAOException {
		return (int) this.em.createQuery("SELECT min(l.id) from Livre l").getSingleResult();
	}
	
	public void close() {
		this.em.close();
	}
}
