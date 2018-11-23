package fr.eni.jpa.service;

import java.util.List;

import fr.eni.jpa.bean.Style;
import fr.eni.jpa.dao.GenericDao;
import fr.eni.jpa.dao.GenericDaoImpl;

public class GestionStyle {
	private GenericDao<Style, Integer> daoStyle;
	
	public GestionStyle() {
		daoStyle = new GenericDaoImpl<>(Style.class);
	}
	
	public List<Style> getListe()
	{
		return daoStyle.getAll();
	}

	public void ajouter(String libelle) {
		//Vérifier éventuellement auparavant la 
		//bonne saisie des informations
		//....
		Style styleAAjouter = new Style(libelle);
		daoStyle.ajouter(styleAAjouter);
	}

	public void supprimer(int idStyleASupprimer) {
		daoStyle.supprimerParPK(idStyleASupprimer);
	}

	public void modifier(int idStyleAModifier, String nouveauLibelle) {
		Style styleAModifier = new Style(nouveauLibelle);
		styleAModifier.setId(idStyleAModifier);
		
		daoStyle.modifier(styleAModifier);
		
	}
}









