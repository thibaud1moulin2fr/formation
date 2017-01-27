package fr.thibaud.gestionparking.view;

import fr.thibaud.gestionparking.dal.DAO;
import fr.thibaud.gestionparking.dal.PersonneDAO;
import fr.thibaud.gestionparking.dal.VoitureDAO;
import fr.thibaud.gestionparking.model.Personne;
import fr.thibaud.gestionparking.model.Voiture;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DAO<Personne> daoP = null;
		daoP = new PersonneDAO();
		DAO<Voiture> daoV = null;
		daoV = new VoitureDAO();
		Personne personne = daoP.find().get(0);
		Voiture voiture = daoV.find().get(0);
		voiture.setPersonne(personne);
		daoV.update(voiture);
		
	}

}
