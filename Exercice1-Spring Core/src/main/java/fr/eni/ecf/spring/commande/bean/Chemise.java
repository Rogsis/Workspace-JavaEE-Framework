package fr.eni.ecf.spring.commande.bean;

public class Chemise extends Produit {
	
	private int taille;

	public Chemise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Chemise(String ref, String libelle, int quantite, int taille) {
		super(ref, libelle, quantite);
		this.taille = taille;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chemise [taille=");
		builder.append(taille);
		builder.append(", ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
