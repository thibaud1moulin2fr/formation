package fr.thibaud.tp1.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.thibaud.tp1.object.Client;

public class TestClient {

	private Client client;
	private String adresse = "Rue des pétunias", nom = "La Vilette", prenom = "Jean-Norbert", ville = "Moultu", cp = "55666";
	@Before
	public void init(){
		
		try {
			client = new Client(adresse, nom, prenom, ville, cp);
			System.out.println(client.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testCreateClient() {
		assertEquals(adresse, client.getAdresse());
	}

}
