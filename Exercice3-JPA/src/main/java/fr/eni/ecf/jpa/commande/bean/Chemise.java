package fr.eni.ecf.jpa.commande.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CHEMISES")
@DiscriminatorValue(value="CHEM")
public class Chemise extends Produit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="TAILLE")
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
