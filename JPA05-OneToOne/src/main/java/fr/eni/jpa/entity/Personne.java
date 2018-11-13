package fr.eni.jpa.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="PERSONNES_ONETOONE")
public class Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "NOM", length=50, nullable=false)
	private String nom;
	
	@Column(name= "PRENOM", length=50, nullable=false)
	private String prenom;
	
	@Column(name= "DDN", length=50, nullable=true)
	@Temporal(TemporalType.DATE)
	private Calendar dateNaissance;
	@Transient
	private int age;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Adresse adresse;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Calendar getDateNaissance() {
		return dateNaissance;
	}
	
	public void setDateNaissance(Calendar dateNaissance) {
		if(dateNaissance!=null) {
			this.dateNaissance = dateNaissance;
		}
		else {
			this.dateNaissance = new GregorianCalendar();
		}
		this.setAge(new GregorianCalendar().get(Calendar.YEAR) - this.dateNaissance.get(Calendar.YEAR));
	}
	
	public int getAge() {
		return age;
	}
	private void setAge(int age) {
		this.age = age;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Personne() {
		super();
	}
	
	public Personne(int id, String nom, String prenom, Calendar dateNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.setDateNaissance(dateNaissance);
	}
	public Personne(String nom, String prenom, Calendar dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.setDateNaissance(dateNaissance);
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateNaissance=");
		builder.append(sdf.format(dateNaissance.getTime()));
		builder.append(", age=");
		builder.append(age);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append("]");
		return builder.toString();
	}

	

}
