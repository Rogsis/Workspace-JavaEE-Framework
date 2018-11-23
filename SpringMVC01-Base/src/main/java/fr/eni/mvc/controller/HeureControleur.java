package fr.eni.mvc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/requeteHeure")
public class HeureControleur {

	@RequestMapping(method=RequestMethod.GET)
	public String donneMoiLHeure(ModelMap map)
	{
		LocalDateTime maintenant = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String maintenantString = maintenant.format(dtf);
		
		map.addAttribute("maintenant",maintenantString);
		
		
		List<String> infos = new ArrayList<String>();
		infos.add("bonjour");
		infos.add("tout");
		infos.add("le");
		infos.add("monde");
		
		map.addAttribute("infos",infos);
		
		
		return "pageHeure";
	}
}
