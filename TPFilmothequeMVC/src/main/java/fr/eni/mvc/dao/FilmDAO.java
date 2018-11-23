package fr.eni.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.eni.mvc.bean.Film;

@Repository(value="filmDAO")
public interface FilmDAO extends JpaRepository<Film, Integer> {

	@Query("from Film f left join fetch f.style left join fetch f.real")
	public List<Film> getFilmsAvecStyleEtRealisateur();
	
	@Query("from Film f left join fetch f.style "
			+ "left join fetch f.real "
			+ "left join fetch f.acteurs "
			+ "where f.id=:id")
	public Film getFilmById(@Param("id") int id);
}
