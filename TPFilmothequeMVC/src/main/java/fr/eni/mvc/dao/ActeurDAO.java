package fr.eni.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.mvc.bean.Acteur;
import fr.eni.mvc.bean.Realisateur;

@Repository("acteurDAO")
public interface ActeurDAO extends JpaRepository<Acteur, Integer> {

	Acteur findByNomAndPrenom(String nom, String prenom);

}
