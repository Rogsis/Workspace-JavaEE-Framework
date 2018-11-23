package fr.eni.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.spring.bean.Style;

@Repository(value="styleRepository")
public interface StyleRepository extends JpaRepository<Style, Integer>{

}
