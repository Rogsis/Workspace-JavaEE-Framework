package fr.eni.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADRESSES_ONETOMANY_BI")
public class Adresse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String ville;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Personne personne;

	public Adresse() {
		// TODO Auto-generated constructor stub
		this.personne = new Personne();
	}

	public Adresse(String ville) {
		super();
		this.ville = ville;
		this.personne = new Personne();
	}
	
	public Adresse(String ville, Personne personne) {
		super();
		this.ville = ville;
		this.personne = personne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adresse [id=");
		builder.append(id);
		builder.append(", ville=");
		builder.append(ville);
		builder.append("]");
		return builder.toString();
	}
}
