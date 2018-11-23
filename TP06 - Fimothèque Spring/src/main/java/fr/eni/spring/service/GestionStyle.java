package fr.eni.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.eni.spring.bean.Style;
import fr.eni.spring.dao.StyleRepository;

@Service(value="gestionStyle")
public class GestionStyle {
	
	@Resource(name="styleRepository")
	private StyleRepository sRep;
	
	public List<Style> getListe()
	{
		return this.sRep.findAll();
	}
	
	public void ajouter(Style style) {
		//Vérifier éventuellement auparavant la 
		//bonne saisie des informations
		//....
		this.sRep.save(style);
	}

	public void supprimer(int idStyleASupprimer) {
		this.sRep.delete(idStyleASupprimer);
	}
}
