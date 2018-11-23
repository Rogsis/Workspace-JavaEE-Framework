package fr.eni.ecf.spring.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.eni.ecf.spring.mvc.bean.Livre;
import fr.eni.ecf.spring.mvc.dao.LivreDAO;

@Service(value="livreService")
public class LivreService {
	
	@Resource(name="livreDAO")
	private LivreDAO livreDAO;
	
	public List<Livre> getLivres(){
		return this.livreDAO.findAll();
	}
	
	public void enregistrer(Livre livre) {
		this.livreDAO.save(livre);
	}
	
	public void supprimer(String isbn) {
		this.livreDAO.delete(isbn);
	}
}
