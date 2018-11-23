package fr.eni.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.spring.bean.Couleur;

public interface CouleurRepository extends JpaRepository<Couleur, Integer>{

}
