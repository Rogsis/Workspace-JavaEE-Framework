package fr.eni.spring.bean;

public class Piano implements Instrument {

	@Override
	public void afficher() {
		System.out.println("Je suis un piano");
	}

	@Override
	public void jouer() {
		System.out.println("Je joue le morceau (partie piano)");
	}

}
