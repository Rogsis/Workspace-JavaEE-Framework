package fr.eni.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.eni.spring.bean.Personne;

public interface PersonneDAO extends JpaRepository<Personne, Integer> {
	
	public Personne findByNom(String nom);
	public List<Personne> findByNomLike(String partieNom);
	public List<Personne> findAllByOrderByMdp();
	
	@Query(value="from Personne p where p.id>:id")
	public List<Personne> getPersonnesAvecIdSupA(@Param("id") int id);
	
}
