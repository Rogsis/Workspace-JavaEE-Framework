package fr.eni.ecf.spring.commande.bean;

public class Adresse {
	
	private int id;
	private String codePostal;
	private String ville;
	
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public Adresse(int id, String codePostal, String ville) {
		super();
		this.id = id;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse(String codePostal, String ville) {
		super();
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adresse [id=");
		builder.append(id);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append("]");
		return builder.toString();
	}

}
