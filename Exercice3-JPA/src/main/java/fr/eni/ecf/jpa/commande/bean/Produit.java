package fr.eni.ecf.jpa.commande.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="PRODUITS")
@DiscriminatorColumn(name="DISCR")
@DiscriminatorValue(value="P")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Produit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID", length=50)
	private String ref;
	@Column(name="LIBELLE", length=50)
	private String libelle;
	@Column(name="QUANTITE")
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
