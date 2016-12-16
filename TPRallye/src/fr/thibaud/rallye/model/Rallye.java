package fr.thibaud.rallye.model;

import java.util.Date;

public class Rallye {
	private Date date;
	private String pays;
	private int specialeIndex = 0;
	private Speciale[] speciales = new Speciale[20];
	public Rallye(String pays, Date date) {
		super();
		this.date = date;
		this.pays = pays;
	}
	public void ajouterSpeciale(Speciale speciale){
		if(specialeIndex < 20){
			speciales[specialeIndex] = speciale;
			specialeIndex++;
		}
	}
	public String infosRallye(boolean plusSpeciale) {
		String specialesStr = "";
		for(Speciale speciale : speciales){
			if(speciale != null){
				specialesStr += "\n" + speciale.infosSpeciale();
			}
		}
		return "Rallye [date=" + date + ", pays=" + pays + ", specialeIndex="
				+ specialeIndex + (plusSpeciale ? ", \nspeciales=" + specialesStr : "") + "]" ;
	}
	public Speciale getSpeciale(String nom){
		for(Speciale speciale : this.speciales){
			if(speciale.getNom().equals(nom)) return speciale;
		}
		return null;
	}
	//public getClassementGeneral
}
