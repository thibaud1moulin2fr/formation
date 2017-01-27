package fr.thibaud.testgestionparking;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.thibaud.gestionparking.dal.VoitureDAO;
import fr.thibaud.gestionparking.model.Voiture;

public class TestVoitureDAO {

	private VoitureDAO dao = null;
	private Voiture voiture = null;
	private Voiture voiture2 = null;
	private Voiture voitureTmp = null;
	private List<Voiture> voitures = null;
	private String nom = null, pI = null;
	private String nom2 = null, pI2 = null;
	private String nom3 = null, pI3 = null;
	@Before
	public void setUp() throws Exception {
		dao = new VoitureDAO();
		nom = "Renault Clio II";
		pI = "KO 969 NU";
		nom2 = "Lamborgini Gallardo Rose Fushia";
		pI2 = "SU 503 BT";
		nom3 = "Opel Corsa III";
		pI3 = "MI 547 JB";
		voiture = new Voiture(nom, pI);
		voiture2 = new Voiture(nom2, pI2);
		voitureTmp = new Voiture();
		try {
			voiture = dao.create(voiture);
			voiture2 = dao.create(voiture2);
			voitures = dao.find();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		try {
			voitures = dao.find();
			for (Voiture v : voitures)
				dao.delete(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreateVoiture() {
		assertEquals(nom, voiture.getNom());
		assertEquals(pI, voiture.getpI());
		assertEquals(nom2, voiture2.getNom());
		assertEquals(pI2, voiture2.getpI());
	}

	@Test
	public void testUpdateVoiture() {
		voitureTmp = voiture;
		voitureTmp.setNom(nom3);
		voitureTmp.setpI(pI3);
		try {
			dao.update(voitureTmp);
			voiture = dao.find(voiture.getIdVoiture());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(nom3, voiture.getNom());
		assertEquals(pI3, voiture.getpI());
	}

	@Test
	public void testDeleteVoiture() {
		int size = voitures.size();
		try {
			dao.delete(voiture2);
			voitures = dao.find();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(size - 1, voitures.size());
	}

	@Test
	public void testFindInt() {
		try {
			voitureTmp = dao.find(voiture.getIdVoiture());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(nom, voitureTmp.getNom());
		assertEquals(pI, voitureTmp.getpI());
	}

	@Test
	public void testFind() {
		assertEquals(nom, voitures.get(0).getNom());
		assertEquals(pI, voitures.get(0).getpI());

		assertEquals(nom2, voitures.get(1).getNom());
		assertEquals(pI2, voitures.get(1).getpI());
	}

}
