package fr.eni.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.spring.bean.Film;

@Repository(value="filmDAO")
public interface FilmRepository extends JpaRepository<Film, Integer>{

}
