package fr.eni.ecf.spring.commande.bean;

public class Ceinture extends Produit {
	
	private String couleur;
	
	public Ceinture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ceinture(String ref, String libelle, int quantite, String couleur) {
		super(ref, libelle, quantite);
		this.couleur = couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ceinture [couleur=");
		builder.append(couleur);
		builder.append(", ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
