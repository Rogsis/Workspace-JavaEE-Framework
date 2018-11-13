package fr.eni.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LivreJPA")
public class Livre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="AUTEUR", nullable=false)
	private String auteur;
	@Column(name="TITRE", nullable=false)
	private String titre;
	@Column(name="NBPAGES", nullable=false)
	private int nbPages;
	
	public Livre() {
		super();
	}

	public Livre(String auteur, String titre, int nbPages) {
		super();
		this.auteur = auteur;
		this.titre = titre;
		this.nbPages = nbPages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [id=");
		builder.append(id);
		builder.append(", auteur=");
		builder.append(auteur);
		builder.append(", titre=");
		builder.append(titre);
		builder.append(", nbPages=");
		builder.append(nbPages);
		builder.append("]");
		return builder.toString();
	}
	
	
}
