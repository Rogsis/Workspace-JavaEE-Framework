package fr.eni.ecf.jpa.commande.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.ecf.jpa.commande.bean.Commande;

public class CommandeDAO {
	
	public void add(Commande c) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(c);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}
	
	public List<Commande> findAll(){
		String req = "SELECT Object(c) FROM Commande c";
		
		EntityManager em = DAOUtil.getEntityManager();
		List<Commande> liste =  em
				.createQuery(req, Commande.class)
				.getResultList();
		em.close();
		
		return liste;
	}

	public Commande findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Commande p = em.find(Commande.class, id);
		em.close();
		return p;
	}


	

}
