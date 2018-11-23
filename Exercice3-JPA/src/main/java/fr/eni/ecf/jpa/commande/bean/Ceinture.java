package fr.eni.ecf.jpa.commande.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CEINTURES")
@DiscriminatorValue(value="CEIN")
public class Ceinture extends Produit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="COULEUR", length=50)
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
