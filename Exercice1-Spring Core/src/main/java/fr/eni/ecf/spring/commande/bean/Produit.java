package fr.eni.ecf.spring.commande.bean;

public abstract class Produit {
	
	private String ref;
	private String libelle;
	private int quantite;
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	public Produit(String ref, String libelle, int quantite) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.quantite = quantite;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produit [ref=");
		builder.append(ref);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append("]");
		return builder.toString();
	}
	
	

}
