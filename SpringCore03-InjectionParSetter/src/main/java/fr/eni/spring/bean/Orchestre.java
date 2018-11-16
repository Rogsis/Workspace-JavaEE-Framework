package fr.eni.spring.bean;

import java.util.ArrayList;
import java.util.List;

public class Orchestre {

	private List<Musicien> musiciens;
	
	public Orchestre() {
		this.musiciens=new ArrayList<Musicien>();
	}
	
	public void ajouter(Musicien musicien)
	{
		this.musiciens.add(musicien);
	}
	
	public void jouer()
	{
		for(Musicien musicien: this.musiciens)
		{
			musicien.jouerMorceau();
		}
	}
}
