package fr.thibaud.gestionparking.view;

import java.util.List;

import fr.thibaud.gestionparking.dal.ConnectionDAO;
import fr.thibaud.gestionparking.dal.DAO;
import fr.thibaud.gestionparking.dal.PersonneDAO;
import fr.thibaud.gestionparking.model.Personne;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DAO<Personne> dao = new PersonneDAO(ConnectionDAO.getConnection());
		Personne personne = new Personne("Moulin", "Thibaud");
		dao.create(personne);
		List<Personne> personnes = dao.find();
		System.out.println(personnes.toString());
	}

}
