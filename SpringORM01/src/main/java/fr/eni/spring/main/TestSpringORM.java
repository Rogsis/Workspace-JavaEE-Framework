package fr.eni.spring.main;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.eni.spring.bean.Personne;
import fr.eni.spring.dao.PersonneDAO;


public class TestSpringORM {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		
		
		PersonneDAO pdao = context.getBean("personneDAO",PersonneDAO.class);
		
		Personne nouvellePersonne = new Personne();
		nouvellePersonne.setNom("Castafiore");
		nouvellePersonne.setMdp("bijoux");
		pdao.ajouter(nouvellePersonne);
		//PersonneDAO pdao = context.getBean(PersonneDAO.class);
		for(Personne p : pdao.getPersonnes())
		{
			System.out.println(p);
		}
		
		context.close();
	}
}
