package fr.thibaud.rallye.model;

import java.util.Date;

public class Speciale {
	private Date jour_heure;
	private double distance;
	private String nom;
	private int resultatIndex = 0;
	private Resultat[] resultats = new Resultat[50];
	private TypeEpreuve type;
	public Speciale(String nom, Date jour_heure, double distance, TypeEpreuve type) {
		super();
		this.nom = nom;
		this.jour_heure = jour_heure;
		this.distance = distance;
		this.type = type;
	}
	public String getNom() {
		return nom;
	}
	public Resultat[] getClassement(){
		return resultats;
	}
	public void ajouterResultat(Resultat resultat){
		if(resultatIndex < 50){
			resultats[resultatIndex] = resultat;
			resultatIndex++;
		}
	}
	public String infosSpeciale() {
		String resultatsStr = "";
		for(Resultat resultat : resultats){
			if(resultat != null){
				resultatsStr += "\n" + resultat.infosResultat();
			}
		}
		return "Speciale [jour_heure=" + jour_heure + ", distance=" + distance
				+ ", nom=" + nom + ", resultatIndex=" + resultatIndex
				+ ", \nresultats=" + resultatsStr + ", type="
				+ type + "]";
	}
}
