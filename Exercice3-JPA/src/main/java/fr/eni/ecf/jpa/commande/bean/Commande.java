package fr.eni.ecf.jpa.commande.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMMANDES")
public class Commande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Client client;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Produit> produits;
	
	public Commande() {
		// TODO Auto-generated constructor stub
		this.produits = new ArrayList<Produit>();
	}
	
	public Commande(Client client, List<Produit> produits) {
		super();
		this.client = client;
		this.produits = produits;
	}

	public Commande(int id, Client client, List<Produit> produits) {
		super();
		this.id = id;
		this.client = client;
		this.produits = produits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commande [id=");
		builder.append(id);
		builder.append(", client=");
		builder.append(client);
		builder.append(", produits=");
		builder.append(produits);
		builder.append("]");
		return builder.toString();
	}

}
