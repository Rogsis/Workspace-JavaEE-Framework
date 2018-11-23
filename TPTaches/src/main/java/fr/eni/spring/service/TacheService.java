package fr.eni.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.eni.spring.bean.Tache;
import fr.eni.spring.dao.TacheDAO;

@Service(value="tacheService")
public class TacheService {
	
	@Resource(name="tacheDAO")
	private TacheDAO tacheDAO;
	
	
	public List<Tache> getToutesLesTaches()
	{
		return this.tacheDAO.getTaches();
	}
}
