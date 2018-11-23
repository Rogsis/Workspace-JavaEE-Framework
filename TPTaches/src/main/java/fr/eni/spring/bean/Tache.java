package fr.eni.spring.bean;

public class Tache {
	private int id;
	private String libelle;
	private int importance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	public Tache() {
		// TODO Auto-generated constructor stub
	}
	public Tache(int id, String libelle, int importance) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.importance = importance;
	}
	@Override
	public String toString() {
		return "Tache [id=" + id + ", libelle=" + libelle + ", importance=" + importance + "]";
	}
	
	
}
