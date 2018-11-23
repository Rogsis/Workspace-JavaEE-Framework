package fr.eni.ecf.spring.commande.bean;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	
	private int id;
	private Client client;
	private List<Produit> produits;
	
	public Commande() {
		// TODO Auto-generated constructor stub
		this.produits = new ArrayList<Produit>();
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
