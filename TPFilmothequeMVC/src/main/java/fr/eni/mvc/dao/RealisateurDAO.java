package fr.eni.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.mvc.bean.Realisateur;

@Repository("realisateurDAO")
public interface RealisateurDAO extends JpaRepository<Realisateur, Integer> {

	Realisateur findByNomAndPrenom(String nom, String prenom);

}
