package fr.eni.mvc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="FILMS")
public class Film implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String titre;
	private int annee;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Style style;

	@ManyToOne(fetch=FetchType.EAGER)
	private Realisateur real;
	private int duree;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Acteur> acteurs;
	
	private boolean vu;
	
	@Lob
	private String synopsis;

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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Realisateur getReal() {
		return real;
	}

	public void setReal(Realisateur real) {
		this.real = real;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
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
			this.acteurs=new ArrayList<>();
		}
		this.acteurs.addAll(acteurs);
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
	
	public Film() {
		this.acteurs=new ArrayList<>();
	}

	public Film(int id, String titre, int annee, Style style, Realisateur real, int duree, List<Acteur> acteurs,
			boolean vu, String synopsis) {
		super();
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.style = style;
		this.real = real;
		this.duree = duree;
		this.acteurs = acteurs;
		this.vu = vu;
		this.synopsis = synopsis;
	}

	public Film(String titre, int annee, Style style, Realisateur real, int duree, List<Acteur> acteurs, boolean vu,
			String synopsis) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.style = style;
		this.real = real;
		this.duree = duree;
		this.acteurs = acteurs;
		this.vu = vu;
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", annee=" + annee + ", style=" + style + ", real=" + real
				+ ", duree=" + duree + ", acteurs=" + acteurs + ", vu=" + vu + ", synopsis=" + synopsis + "]";
	}
	
	
	
}
