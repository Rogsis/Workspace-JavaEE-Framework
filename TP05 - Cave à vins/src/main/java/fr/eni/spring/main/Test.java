package fr.eni.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.spring.bean.Bouteille;
import fr.eni.spring.bean.Couleur;
import fr.eni.spring.bean.Region;
import fr.eni.spring.dao.BouteilleRepository;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		BouteilleRepository bRep = context.getBean(BouteilleRepository.class);
		
		Bouteille b1 = new Bouteille();
		b1.setMillesime("Chateau Lacroix");
		b1.setNom("Lacroix 2010");
		b1.setPetillant(false);
		b1.setQuantite(1);
		b1.setCouleur(new Couleur("Rouge"));
		b1.setRegion(new Region("Bordeaux"));
		
		bRep.save(b1);
		
		System.out.println("Bouteille enregistrée : " + bRep.findOne(1));
	}

}
