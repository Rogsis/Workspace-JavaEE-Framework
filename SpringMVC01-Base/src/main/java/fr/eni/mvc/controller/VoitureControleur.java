package fr.eni.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/requeteVoiture")
public class VoitureControleur {

	@RequestMapping
	public ModelAndView donnerMoiUneVoiture()
	{
		/*ModelAndView mav = 
				new ModelAndView("pageVoiture", "voiture", "RENAULT ZOE");*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pageVoiture");
		mav.addObject("voiture", "RENAULT ZOE");
		return mav;
	}
}
