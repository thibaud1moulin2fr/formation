package fr.thibaud.tp3.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.thibaud.tp3.model.Editeur;

public class TestEditeur {

	private String nomGroupe1, adresse1, siteWeb1, 
	nomGroupe2, adresse2;
	Editeur editeur1, editeur2;
	@Before
	public void init(){
		nomGroupe1 = "Hachette";
		adresse1 = "169 Bd Marboeuf 75012 Paris";
		siteWeb1 = "www.hachette.com";
		editeur1 = new Editeur(nomGroupe1, adresse1, siteWeb1);
		nomGroupe2 = "Moulino Editions";
		adresse2 = "4 rue du grain moulu";
		editeur2 = new Editeur(nomGroupe2, adresse2);
	}
	@Test
	public void testConstructeur3Params() {
		String test = "Editeur [nomGroupe=" + nomGroupe1 + ", adresse=" + adresse1
				+ ", toString()=" + "Personne [siteWeb=" + siteWeb1 + "]" + "]";
		assertEquals(test, editeur1.toString());
	}
	@Test
	public void testConstructeur2Params(){
		String test = "Editeur [nomGroupe=" + nomGroupe2 + ", adresse=" + adresse2
				+ ", toString()=" + "Personne [siteWeb=" + "null" + "]" + "]";
		assertEquals(test, editeur2.toString());
	}
}
