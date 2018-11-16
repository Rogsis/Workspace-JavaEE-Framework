package fr.eni.jpa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FILMS")
public class Film implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String année;
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="style")
	private Style style;
	private String duree;
	private boolean vu;
	private String synopsis;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch=FetchType.EAGER)
	@JoinColumn(name="realisateur_id")
	private Realisateur realisateur;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch=FetchType.LAZY)
	@JoinTable(name = "FILMS_ACTEURS", joinColumns = { @JoinColumn(name = "filmId") }, inverseJoinColumns = {
			@JoinColumn(name = "acteurId") })
	private List<Acteur> acteurs;
	
	public Film() {
		// TODO Auto-generated constructor stub
		this.acteurs = new ArrayList<Acteur>();
	}

	public Film(String titre, String année, Style style, String duree, boolean vu, String synopsis,
			Realisateur realisateur) {
		super();
		this.titre = titre;
		this.année = année;
		this.style = style;
		this.duree = duree;
		this.vu = vu;
		this.synopsis = synopsis;
		this.realisateur = realisateur;
		this.acteurs = new ArrayList<Acteur>();
	}

	public Film(String titre, String année, Style style, String duree, boolean vu, String synopsis,
			Realisateur realisateur, List<Acteur> acteurs) {
		super();
		this.titre = titre;
		this.année = année;
		this.style = style;
		this.duree = duree;
		this.vu = vu;
		this.synopsis = synopsis;
		this.realisateur = realisateur;
		this.acteurs = acteurs;
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

	public String getAnnée() {
		return année;
	}

	public void setAnnée(String année) {
		this.année = année;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
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

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		if(this.acteurs!=null)
		{
			this.acteurs.clear();
		}
		else
		{
			this.acteurs = new ArrayList<Acteur>();
		}
		this.acteurs.addAll(acteurs);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=");
		builder.append(id);
		builder.append(", titre=");
		builder.append(titre);
		builder.append(", année=");
		builder.append(année);
		builder.append(", style=");
		builder.append(style);
		builder.append(", duree=");
		builder.append(duree);
		builder.append(", vu=");
		builder.append(vu);
		builder.append(", synopsis=");
		builder.append(synopsis);
		builder.append(", realisateur=");
		builder.append(realisateur);
		builder.append(", acteurs=");
		builder.append(acteurs);
		builder.append("]");
		return builder.toString();
	}
}
