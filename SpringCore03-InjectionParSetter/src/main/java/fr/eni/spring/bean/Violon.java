package fr.eni.spring.bean;

public class Violon implements Instrument {

	@Override
	public void afficher() {
		System.out.println("Je suis un violon");
	}

	@Override
	public void jouer() {
		System.out.println("Je joue le morceau (partie violon)");
	}

}
