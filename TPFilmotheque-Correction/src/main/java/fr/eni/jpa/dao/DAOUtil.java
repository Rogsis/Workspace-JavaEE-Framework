package fr.eni.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAOUtil {
	private static EntityManagerFactory emf;
	
	static
	{
		emf = Persistence.createEntityManagerFactory("SQLSERVER_UP");
	}
	
	/**
	 * 
	 * @return une nouvelle instance d'EntityManager ou null si problème à la création
	 */
	public static EntityManager getEntityManager()
	{
		try
		{
			return emf.createEntityManager();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Ne lève jamais d'exception: 
	 * seule une trace est écrite dans la console en cas de problème
	 */
	public static void close() //throws DAOException
	{
		try
		{
			emf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
