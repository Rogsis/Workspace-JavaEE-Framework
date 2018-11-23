package fr.eni.ecf.jpa.commande;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecf.jpa.commande.bean.Adresse;
import fr.eni.ecf.jpa.commande.bean.Ceinture;
import fr.eni.ecf.jpa.commande.bean.Chemise;
import fr.eni.ecf.jpa.commande.bean.Client;
import fr.eni.ecf.jpa.commande.bean.Commande;
import fr.eni.ecf.jpa.commande.bean.Produit;
import fr.eni.ecf.jpa.commande.dao.CommandeDAO;
import fr.eni.ecf.jpa.commande.dao.DAOUtil;

public class TestCommande {

	public static void main(String[] args) {

		// Ajout des produits
		
		Chemise ch1 = new Chemise("CH-bleue-40", "Chemisette bleue", 2, 40);
		Chemise ch2 = new Chemise("CH-jaune-38", "Chemise jaune", 1, 38);
		
		Ceinture ce1 = new Ceinture("CE-marron-cuir", "Ceinture cuir marron", 1, "Marron");
		
		List<Produit> listeP = new ArrayList<>();
		listeP.add(ch1); listeP.add(ch2); listeP.add(ce1);

		Client c1 = new Client("Leblond", "Jeanne", new Adresse("44000", "Nantes")); 
		
		Commande com1 = new Commande(c1, listeP);
		CommandeDAO comDao = new CommandeDAO();
		try {
			comDao.add(com1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<Commande> listeCom = comDao.findAll();
		System.out.println("\nListe des commandes :");
		for (Commande commande : listeCom) {
			System.out.println(commande);
		}

		
		DAOUtil.close();
	}

}
