package fr.eni.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.spring.bean.Tache;

@Repository(value="tacheDAO")
public class TacheDAOImpl implements TacheDAO {

	private static final String SELECT_ALL = "select id, libelle, importance from taches";
	private static final String INSERT = "insert into taches(libelle, importance) values(?,?)";
	private static final String UPDATE = "update taches set libelle=?, importance=? where id=?";
	private static final String DELETE = "delete from taches where id=?";
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jt;
	
	@Override
	public List<Tache> getTaches() {
		return this.jt.query(SELECT_ALL, 
							//new BeanPropertyRowMapper<Tache>(Tache.class));
							BeanPropertyRowMapper.newInstance(Tache.class));
	}

	@Override
	public void inserer(Tache tache) {
		this.jt.update(INSERT, tache.getLibelle(),tache.getImportance());
	}

	@Override
	public void mettreAJour(Tache tache) {
		this.jt.update(UPDATE,tache.getLibelle(), tache.getImportance(),tache.getId());
	}

	@Override
	public void supprimer(int id) {
		this.jt.update(DELETE,id);
	}

}
