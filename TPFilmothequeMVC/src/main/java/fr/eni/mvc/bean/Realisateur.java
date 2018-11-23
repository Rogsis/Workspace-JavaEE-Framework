package fr.eni.mvc.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="R")
public class Realisateur extends Personne {

	private static final long serialVersionUID = 1L;

	public Realisateur() {
		super();

	}

	public Realisateur(int id, String prenom, String nom) {
		super(id, prenom, nom);

	}

	public Realisateur(String prenom, String nom) {
		super(prenom, nom);

	}

	
}
