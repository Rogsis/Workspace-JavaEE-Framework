package fr.eni.spring.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FILMS")
public class Film {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String annee;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.PERSIST},
			fetch=FetchType.EAGER)
	private Style style;
	private int duree;
	private boolean vu;
	private String synopsis;
	
	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(String titre, String annee, Style style, int duree, boolean vu, String synopsis) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.style = style;
		this.duree = duree;
		this.vu = vu;
		this.synopsis = synopsis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isVu() {
		return vu;
	}

	public void setVu(boolean vu) {
		this.vu = vu;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=");
		builder.append(id);
		builder.append(", titre=");
		builder.append(titre);
		builder.append(", annee=");
		builder.append(annee);
		builder.append(", style=");
		builder.append(style);
		builder.append(", duree=");
		builder.append(duree);
		builder.append(", vu=");
		builder.append(vu);
		builder.append(", synopsis=");
		builder.append(synopsis);
		builder.append("]");
		return builder.toString();
	}
	
	

}
