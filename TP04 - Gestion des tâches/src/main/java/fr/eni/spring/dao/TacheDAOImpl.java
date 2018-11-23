package fr.eni.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.spring.bean.Tache;

@Repository(value="tacheDAO")
public class TacheDAOImpl implements TacheDAO {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public void addTache(Tache t) {
		String req = "insert into TACHES (libelle, importance) values (?, ?)";
		jt.update(req,t.getLibelle(),t.getImportance());
	}

	@Override
	public void deleteTache(Tache t) {
		String req = "delete from TACHES where id=?";
		jt.update(req,t.getId());
	}

	@Override
	public void updateTache(Tache t) {
		String req = "update TACHES SET libelle = ?, importance = ? where id = ?";
		jt.update(req,t.getLibelle(),t.getImportance(),t.getId());
		
	}

	@Override
	public Tache getTache(int id) {
		String req = "select id, libelle, importance from TACHES where id=?";
		return jt.queryForObject(req, Tache.class, id);
	}

	@Override
	public List<Tache> getTaches() {
		String req = "select * from TACHES";
		return jt.queryForList(req, Tache.class);
	}

}
