package fr.eni.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="PERSONNES_COMPOSITE2")
public class Personne implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private PersonnePK personnePK;
	
	@Column(name= "DDN", length=50, nullable=true)
	@Temporal(TemporalType.DATE)
	private Calendar dateNaissance;
	@Transient
	private int age;
	

	public Personne() {
		super();
	}
	
	public Personne(String nom, String prenom, Calendar dateNaissance) {
		super();
		this.personnePK = new PersonnePK(nom,prenom);
		this.setDateNaissance(dateNaissance);
	}

	public PersonnePK getPersonnePK() {
		return personnePK;
	}

	public void setPersonnePK(PersonnePK personnePK) {
		this.personnePK = personnePK;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [personnePK=");
		builder.append(personnePK);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	

	
	

}
