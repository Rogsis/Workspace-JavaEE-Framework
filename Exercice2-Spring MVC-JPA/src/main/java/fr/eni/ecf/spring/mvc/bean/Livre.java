package fr.eni.ecf.spring.mvc.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SpringJdbcLivres")
public class Livre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;
	private String titre;
	private String auteur;
	private int nbPages;
	
	public Livre() {
	}
	
	public Livre(String isbn, String titre, String auteur, int nbPages) {
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
		this.nbPages = nbPages;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	@Override
	public String toString() {
		return "Livre [isbn=" + isbn + ", titre=" + titre + ", auteur=" + auteur + ", nbPages=" + nbPages + "]";
	}
	
	
}
