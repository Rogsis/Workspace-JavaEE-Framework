package fr.eni.spring.bean.type;

public abstract class TypeTheque {
	private String nom;
	private String media;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	
	public TypeTheque() {
		// TODO Auto-generated constructor stub
	}
	public TypeTheque(String nom, String media) {
		super();
		this.nom = nom;
		this.media = media;
	}
	@Override
	public String toString() {
		return "TypeTheque [nom=" + nom + ", media=" + media + "]";
	}
	
}
