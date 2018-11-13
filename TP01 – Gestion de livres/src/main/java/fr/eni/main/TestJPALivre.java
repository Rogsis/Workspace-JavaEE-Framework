package fr.eni.main;

import fr.eni.bean.Livre;
import fr.eni.dao.DAOUtil;
import fr.eni.dao.LivreDAO;
import fr.eni.exception.DAOException;

public class TestJPALivre {

	public static void main(String[] args) {
		
		LivreDAO livreDAO = new LivreDAO();
		Livre livre1 = new Livre("Emile Zola", "La bête humaine", 450);
		Livre livre2 = new Livre("JP Sartre", "Huis Clos", 350);
		Livre livre3 = new Livre("Albert Camus", "L'étranger", 476);
		Livre livre4 = new Livre("Albert Camus", "La Peste", 276);
		
		try {
			System.out.println("Création de 4 livres :" + "\n");
			livreDAO.add(livre1);
			livreDAO.add(livre2);
			livreDAO.add(livre3);
			livreDAO.add(livre4);
			System.out.println("Liste des livres :");
			for (Livre l : livreDAO.findAll()) {
				System.out.println(l.toString());
			}
			System.out.println();
			System.out.println("Liste des livres triés par par titre ascendant:");
			for (Livre l : livreDAO.findAllOrderByTitreAsc()) {
				System.out.println(l.toString());
			}
			System.out.println();
			System.out.println("Liste des livres triés par par titre descendant:");
			for (Livre l : livreDAO.findAllOrderByTitreDesc()) {
				System.out.println(l.toString());
			}
			System.out.println();
			System.out.println("Liste des livres de Camus:");
			for (Livre l : livreDAO.findByAuteur("Albert Camus")) {
				System.out.println(l.toString());
			}
			System.out.println();
			System.out.println("Premier ID : " + livreDAO.getMinId());
			System.out.println("Dernier ID : " + livreDAO.getMaxId());
			System.out.println();
			System.out.println("Livre id = 2 : " + livreDAO.findById(2));
			System.out.println();
			System.out.println("Livre id = 22 : " + livreDAO.findById(22));
			System.out.println();
			livreDAO.delete(livre1);
			livreDAO.delete(3);
			livre2.setAuteur("Jean-Paul Sartre");
			livre2.setNbPages(354);
			livreDAO.update(livre2);
			System.out.println("Liste des livres après suppression et modification :");
			for (Livre l : livreDAO.findAll()) {
				System.out.println(l.toString());
			}
			livreDAO.close();
			DAOUtil.close();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
