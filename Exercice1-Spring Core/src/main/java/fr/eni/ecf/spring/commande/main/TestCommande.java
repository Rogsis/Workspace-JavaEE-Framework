package fr.eni.ecf.spring.commande.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.ecf.spring.commande.bean.Client;
import fr.eni.ecf.spring.commande.bean.Commande;
import fr.eni.ecf.spring.commande.bean.Produit;

public class TestCommande {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Produit produit1 = context.getBean("ch1", Produit.class);
		System.out.println(produit1);
		
		Produit produit2 = context.getBean("ce1", Produit.class);
		System.out.println(produit2);
		
		Client c1 = context.getBean(Client.class);
		System.out.println(c1);

		Commande co = context.getBean(Commande.class);
		System.out.println(co);

		
		
		
		
		((ClassPathXmlApplicationContext) context).close();
		
	}

}
