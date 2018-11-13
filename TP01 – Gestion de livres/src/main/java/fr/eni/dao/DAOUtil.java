package fr.eni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLSERVER_UP");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}

}
