package fr.eni.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Utilisateur")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String login;
	private String password;
	
	public User() {
		super();
	}
	
	public User(int id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}
