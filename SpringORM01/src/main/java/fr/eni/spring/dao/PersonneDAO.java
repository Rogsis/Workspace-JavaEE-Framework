package fr.eni.spring.dao;

import java.util.List;

import fr.eni.spring.bean.Personne;

public interface PersonneDAO {
	public List<Personne> getPersonnes();
	public void ajouter(Personne personne);
}
