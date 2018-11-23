package fr.eni.ecf.spring.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.ecf.spring.mvc.bean.Livre;

@Repository(value="livreDAO")
public interface LivreDAO extends JpaRepository<Livre, String>{
	
}
