package fr.thibaud.tp1.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.thibaud.tp1.object.Livre;

public class TestLivre {

	@Before
	public void init(){
		Livre livre;
		try {
			livre = new Livre("Les bulles roses", "Jean-Marie Du Fenec", 237, "5452-5687-56321");
			System.out.println(livre.toString());
			System.out.println("Prix " + livre.getPrix());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
