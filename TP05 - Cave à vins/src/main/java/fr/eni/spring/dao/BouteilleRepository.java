package fr.eni.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.spring.bean.Bouteille;

public interface BouteilleRepository extends JpaRepository<Bouteille, Integer>{

}
