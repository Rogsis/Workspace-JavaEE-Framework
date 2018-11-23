package fr.eni.spring.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDriverManagerDataSource {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		DataSource ds = context.getBean("datasource", DataSource.class);
		
		for(int i=1;i<=5;i++)
		{
			Connection cnx = ds.getConnection();
			System.out.println("Connexion " + i + " = "+ cnx);
			cnx.close();
		}
		
		context.close();
	}
}
