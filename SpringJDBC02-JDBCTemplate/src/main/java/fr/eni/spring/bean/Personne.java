package fr.eni.spring.bean;

public class Personne {
	private int id;
	private String nom;
	private String mdp;
	
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
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", mdp=" + mdp + "]";
	}
	
	
	
}
