package fr.eni.spring.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOUTEILLES")
public class Bouteille {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private boolean petillant;
	private String millesime;
	private int quantite;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.PERSIST},
			fetch=FetchType.EAGER)
	private Region region;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.PERSIST},
			fetch=FetchType.EAGER)
	private Couleur couleur;
	
	public Bouteille() {
		// TODO Auto-generated constructor stub
	}

	public Bouteille(String nom, boolean petillant, String millesime, int quantite) {
		super();
		this.nom = nom;
		this.petillant = petillant;
		this.millesime = millesime;
		this.quantite = quantite;
	}

	public Bouteille(String nom, boolean petillant, String millesime, int quantite, Region region, Couleur couleur) {
		super();
		this.nom = nom;
		this.petillant = petillant;
		this.millesime = millesime;
		this.quantite = quantite;
		this.region = region;
		this.couleur = couleur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isPetillant() {
		return petillant;
	}

	public void setPetillant(boolean petillant) {
		this.petillant = petillant;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bouteille [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", petillant=");
		builder.append(petillant);
		builder.append(", millesime=");
		builder.append(millesime);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append(", region=");
		builder.append(region);
		builder.append(", couleur=");
		builder.append(couleur);
		builder.append("]");
		return builder.toString();
	}
	

}
