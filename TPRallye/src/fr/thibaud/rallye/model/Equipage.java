package fr.thibaud.rallye.model;

public class Equipage {

	private int dossard;
	private Concurrent pilote, copilote;
	public Equipage( 
			int dossard,
			String nomPilote, String prenomPilote, String nationalitePilote, 
			String nomCoPilote, String prenomCoPilote, String nationaliteCoPilote) {
		this.dossard = dossard;
		pilote = new Concurrent(nomPilote, prenomPilote, nationalitePilote);
		copilote = new Concurrent(nomCoPilote, prenomCoPilote, nationaliteCoPilote);
	}
	public int getDossard() {
		return dossard;
	}
	public String infosEquipage() {
		return "Equipage [dossard=" + dossard + ", \npilote=" + pilote.infosConcurrent()
				+ ", \ncopilote=" + copilote.infosConcurrent() + "]";
	}

}