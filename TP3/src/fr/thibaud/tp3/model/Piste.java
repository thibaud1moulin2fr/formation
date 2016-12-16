/**
 * 
 */
package fr.thibaud.tp3.model;

import java.util.Date;

/**
 * @author Administrateur
 *
 */
public class Piste {

	private int numero;
	private String intitule;
	private Date duree;
	public Piste(int numero, String intitule, Date duree) {
		super();
		this.numero = numero;
		this.intitule = intitule;
		this.duree = duree;
	}
	@Override
	public String toString() {
		return "Piste [numero=" + numero + ", intitule=" + intitule
				+ ", duree=" + duree + "]";
	}
	
}
