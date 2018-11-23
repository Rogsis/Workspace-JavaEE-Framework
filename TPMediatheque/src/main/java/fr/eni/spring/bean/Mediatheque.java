package fr.eni.spring.bean;

import java.util.List;

import javax.annotation.Resource;

import fr.eni.spring.bean.type.TypeTheque;

public class Mediatheque {
	private List<Media> medias;
	
	
	private TypeTheque typeTheque;
	public List<Media> getMedias() {
		return medias;
	}
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
	public TypeTheque getTypeTheque() {
		return typeTheque;
	}
	public void setTypeTheque(TypeTheque typeTheque) {
		this.typeTheque = typeTheque;
	}
	
	
	public Mediatheque() {
		// TODO Auto-generated constructor stub
	}
	public Mediatheque(List<Media> medias, TypeTheque typeTheque) {
		super();
		this.medias = medias;
		this.typeTheque = typeTheque;
	}
	@Override
	public String toString() {
		return "Mediatheque [medias=" + medias + ", typeTheque=" + typeTheque + "]";
	}
	
}
