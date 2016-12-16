package fr.thibaud.rallye.model;

import java.util.Date;

public class Classement {
	private Date cumulTemps;
	private Equipage equipage;
	public Classement(Equipage equipage, Date cumulTemps) {
		super();
		this.equipage = equipage;
		this.cumulTemps = cumulTemps;
	}
	public Date getCumulTemps() {
		return cumulTemps;
	}
	public String infosClassement() {
		return "Classement [cumulTemps=" + cumulTemps + ", \nequipage="
				+ equipage.infosEquipage() + "]";
	}	
}
