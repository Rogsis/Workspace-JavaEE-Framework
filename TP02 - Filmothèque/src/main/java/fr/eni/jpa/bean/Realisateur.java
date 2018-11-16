package fr.eni.jpa.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="REALISATEURS")
public class Realisateur extends Personne{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Realisateur() {
		// TODO Auto-generated constructor stub
	}
	public Realisateur(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

}
