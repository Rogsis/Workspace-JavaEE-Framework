package fr.eni.spring.main;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.eni.spring.bean.Personne;
import fr.eni.spring.dao.PersonneDAO;


public class TestSpringDATA {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		
		
		PersonneDAO pdao = context.getBean("personneDAO",PersonneDAO.class);
		
		Personne nouvellePersonne = new Personne();
		nouvellePersonne.setNom("Castafiore");
		nouvellePersonne.setMdp("bijoux");
		pdao.save(nouvellePersonne);
		
		nouvellePersonne = new Personne();
		nouvellePersonne.setNom("Tournesol");
		nouvellePersonne.setMdp("labo");
		pdao.save(nouvellePersonne);
		//PersonneDAO pdao = context.getBean(PersonneDAO.class);
		/*for(Personne p : pdao.findAll())
		{
			System.out.println(p);
		}*/
		
		/*for(Personne p : pdao.findByNom("Castafiore"))
		{
			System.out.println(p);
		}*/
		System.out.println(pdao.findByNom("Castafiore"));
		
		/*for(Personne p : pdao.findByNomLike("%asta%"))
		{
			System.out.println(p);
		}*/
		
		/*for(Personne p : pdao.findAllByOrderByMdp())
		{
			System.out.println(p);
		}*/
		
		for(Personne p : pdao.getPersonnesAvecIdSupA(1))
		{
			System.out.println(p);
		}
		
		context.close();
		
		
	}
}
