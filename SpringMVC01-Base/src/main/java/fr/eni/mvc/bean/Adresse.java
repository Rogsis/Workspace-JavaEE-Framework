package fr.eni.mvc.bean;

public class Adresse {
	private String ville;

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public Adresse(String ville) {
		super();
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [ville=" + ville + "]";
	}
	
}
