package fr.eni.mvc.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="A")
public class Acteur extends Personne {

	private static final long serialVersionUID = 1L;

	public Acteur() {
		super();
	}

	public Acteur(int id, String prenom, String nom) {
		super(id, prenom, nom);
	}

	public Acteur(String prenom, String nom) {
		super(prenom, nom);
	}

}
