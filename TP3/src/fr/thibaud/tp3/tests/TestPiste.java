package fr.thibaud.tp3.tests;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.thibaud.tp3.model.Piste;

public class TestPiste {

	private int numero;
	private String intitule;
	private Date duree;
	Piste piste;
	
	@Before
	public void init(){
		numero = 5;
		intitule = "Javanaise";
		duree = new GregorianCalendar(0, 0, 0, 0, 5, 21).getGregorianChange();
		piste = new Piste(numero, intitule, duree);
	}
	@Test
	public void test() {
		String test = "Piste [numero=" + numero + ", intitule=" + intitule
				+ ", duree=" + duree + "]";
		Assert.assertEquals(test, piste.toString());
	}

}
