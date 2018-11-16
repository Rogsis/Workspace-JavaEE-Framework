package fr.eni.jpa.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ACTEURS")
public class Acteur extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Acteur() {
		// TODO Auto-generated constructor stub
	}
	public Acteur(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

}
