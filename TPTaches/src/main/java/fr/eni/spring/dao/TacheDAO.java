package fr.eni.spring.dao;

import java.util.List;

import fr.eni.spring.bean.Tache;

public interface TacheDAO {
	public List<Tache> getTaches();
	public void inserer(Tache tache);
	public void mettreAJour(Tache tache);
	public void supprimer(int id);
}
