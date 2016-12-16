package fr.thibaud.rallye.model;

import java.util.Date;

public class Resultat {
	private Date temps;
	private Speciale speciale;
	private Equipage equipage;
	public Resultat(Equipage equipage, Speciale speciale, Date temps) {
		super();
		this.equipage = equipage;
		this.speciale = speciale;
		this.temps = temps;
	}
	public Date getTemps() {
		return temps;
	}
	public Speciale getSpeciale() {
		return speciale;
	}
	public Equipage getEquipage() {
		return equipage;
	}
	public String infosResultat() {
		return "Resultat [temps=" + temps + ", \nspeciale=" + speciale.infosSpeciale()
				+ ", \nequipage=" + equipage.infosEquipage() + "]";
	}
}
