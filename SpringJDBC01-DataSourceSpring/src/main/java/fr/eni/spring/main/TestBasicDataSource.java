package fr.eni.spring.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;

public class TestBasicDataSource {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		DataSource ds = context.getBean("datasource", DataSource.class);
		
		for(int i=1;i<=15;i++)
		{
			Connection cnx = ds.getConnection();
			
			System.out.println("Connexion " + i + " = "+ cnx.hashCode());
			System.out.println(((BasicDataSource)ds).getMaxTotal());
			cnx.close();//Remet la cnx dans le pool
		}
		context.close();
	}
}
