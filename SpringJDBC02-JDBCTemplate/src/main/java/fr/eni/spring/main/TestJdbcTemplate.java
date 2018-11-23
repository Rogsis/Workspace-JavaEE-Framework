package fr.eni.spring.main;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.eni.spring.bean.Personne;


public class TestJdbcTemplate {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		JdbcTemplate jt = context.getBean("jdbcTemplate", JdbcTemplate.class);
		
		String sql = "SELECT id, login as nom, password as mdp FROM Utilisateurs";
		List<Personne> personnes = jt.query(sql, new BeanPropertyRowMapper(Personne.class));
		
		for (Personne personne : personnes) {
			System.out.println(personne);
		}
		
		context.close();
	}
}
