package fr.eni.spring.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.stereotype.Repository;

import fr.eni.spring.bean.Personne;

@Repository(value="personneDAO")
public class PersonneDAOImpl implements PersonneDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Personne> getPersonnes() {
		return this.entityManager.createQuery("from Personne").getResultList();
	}
	
	@Transactional
	public void ajouter(Personne personne)
	{
		this.entityManager.persist(personne);
	}
	
	@Transactional
	public void modifier(Personne personne)
	{
		this.entityManager.merge(personne);
	}

	@Transactional
	public void supprimer(Personne personne)
	{
		this.entityManager.remove(personne);
	}
	
	@Transactional
	public void supprimerParId(int id)
	{
		this.supprimer(this.entityManager.find(Personne.class, id));
	}
	
	
}
