package fr.eni.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.spring.bean.Musicien;

public class TestInjectionSetter {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Musicien musicien = context.getBean("musicien", Musicien.class);
		musicien.jouerMorceau();
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
