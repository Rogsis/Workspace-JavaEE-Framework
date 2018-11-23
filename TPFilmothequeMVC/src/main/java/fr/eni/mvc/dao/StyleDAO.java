package fr.eni.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.mvc.bean.Style;

@Repository(value="styleDAO")
public interface StyleDAO extends JpaRepository<Style, Integer> {

}
