package fr.eni.spring.dao;

import java.util.List;

import fr.eni.spring.bean.Tache;

public interface TacheDAO {
	public void addTache(Tache t);
	public void deleteTache(Tache t);
	public void updateTache(Tache t);
	public Tache getTache (int id);
	public List<Tache> getTaches();

}
