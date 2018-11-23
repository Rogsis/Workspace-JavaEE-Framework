package fr.eni.spring.bean;

public class Media {
	private String titre;
	private String nom;
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Media() {
		// TODO Auto-generated constructor stub
	}
	public Media(String titre, String nom) {
		super();
		this.titre = titre;
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Media [titre=" + titre + ", nom=" + nom + "]";
	}
	
	
}
