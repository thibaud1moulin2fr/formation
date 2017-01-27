package fr.thibaud.testgestionparking;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.thibaud.gestionparking.dal.PersonneDAO;
import fr.thibaud.gestionparking.model.Personne;

public class TestPersonneDAO {
	private PersonneDAO dao = null;
	private Personne personne = null;
	private Personne personne2 = null;
	private Personne personneTmp = null;
	private List<Personne> personnes = null;
	String nom = null, prenom = null;
	String nom2 = null, prenom2 = null;
	String nom3 = null, prenom3 = null;

	@Before
	public void setUp() throws Exception {
		dao = new PersonneDAO();
		nom = "Moulin";
		prenom = "Thibaud";
		nom2 = "Du Poids";
		prenom2 = "Marc";
		nom3 = "Lamartine";
		prenom3 = "Jean-Hubert";
		personne = new Personne(nom, prenom);
		personne2 = new Personne(nom2, prenom2);
		personneTmp = new Personne();
		try {
			personne = dao.create(personne);
			personne2 = dao.create(personne2);
			personnes = dao.find();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		try {
			personnes = dao.find();
			for (Personne pers : personnes) {
				dao.delete(pers);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCreatePersonne() {
		assertEquals(nom, personnes.get(0).getNom());
		assertEquals(prenom, personnes.get(0).getPrenom());
	}

	@Test
	public void testUpdatePersonne() {
		personneTmp = personne;
		personneTmp.setNom(nom3);
		personneTmp.setPrenom(prenom3);
		try {
			dao.update(personneTmp);
			personne = dao.find(personne.getIdPersonne());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(nom3, personne.getNom());
		assertEquals(prenom3, personne.getPrenom());
	}

	@Test
	public void testDeletePersonne() {
		int size = personnes.size();
		try {
			dao.delete(personne2);
			personnes = dao.find();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(size - 1, personnes.size());
	}

	@Test
	public void testFindInt() {
		try {
			personneTmp = dao.find(personne.getIdPersonne());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(personne.getNom(), personneTmp.getNom());
		assertEquals(personne.getPrenom(), personneTmp.getPrenom());
		assertEquals(personne.getIdPersonne(), personneTmp.getIdPersonne());
	}

	@Test
	public void testFind() {
		assertEquals(nom, personnes.get(0).getNom());
		assertEquals(prenom, personnes.get(0).getPrenom());

		assertEquals(nom2, personnes.get(1).getNom());
		assertEquals(prenom2, personnes.get(1).getPrenom());
	}
}
