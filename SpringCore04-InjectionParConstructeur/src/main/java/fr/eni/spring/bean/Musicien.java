package fr.eni.spring.bean;

public class Musicien {

	private String morceau;
	private Instrument instrument;
	
	public String getMorceau() {
		return morceau;
	}
	public void setMorceau(String morceau) {
		this.morceau = morceau;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument intrument) {
		this.instrument = intrument;
	}
	
	public Musicien() {

	}
	public Musicien(String morceau, Instrument instrument) {
		super();
		this.morceau = morceau;
		this.instrument = instrument;
	}
	
	public void jouerMorceau()
	{
		System.out.println(this.morceau);
		this.instrument.afficher();
		this.instrument.jouer();
	}
}



