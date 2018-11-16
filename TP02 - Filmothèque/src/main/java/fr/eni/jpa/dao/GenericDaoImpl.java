package fr.eni.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.eni.jpa.dao.DAOUtil;

public class GenericDaoImpl<T> implements GenericDao<T> {

	public GenericDaoImpl() {
	}

	@Override
	public void save(T entity) {
		EntityManager em = DAOUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(em.merge(entity));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void update(T entity) {
		EntityManager em = DAOUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void delete(T entity) {
		EntityManager em = DAOUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.merge(entity));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public T get(Class<T> t, Object id) {
		T result = null;
		EntityManager em = DAOUtil.getEntityManager();
		try {
			result = em.find(t, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
		}
		return result;
	}

	@Override
	public List<T> list(Class<T> t) {
		EntityManager em = DAOUtil.getEntityManager();
		List<T> result = null;
		TypedQuery<T> query;
		try {
			query = em.createQuery("FROM " + t.getSimpleName(), t);
			result = query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			em.close();
		}
		return result;
	}

}
