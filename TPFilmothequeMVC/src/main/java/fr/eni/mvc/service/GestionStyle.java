package fr.eni.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.eni.mvc.bean.Style;
import fr.eni.mvc.dao.StyleDAO;

@Service(value="gestionStyle")
public class GestionStyle {

	@Resource(name="styleDAO")
	private StyleDAO styleDAO;
	
	public List<Style> getStyles()
	{
		return this.styleDAO.findAll();
	}
	
	public void enregistrer(Style style)
	{
		this.styleDAO.save(style);
	}

	public void supprimer(int id) {
		this.styleDAO.delete(id);
	}

	public Style getStyle(int id) {
		return this.styleDAO.findOne(id);
	}
	
}
