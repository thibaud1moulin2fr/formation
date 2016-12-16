package fr.thibaud.rallye.model;

public class Concurrent {
	private String nom, prenom, nationalite;

	public Concurrent(String nom, String prenom, String nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
	}

	public String infosConcurrent() {
		return "Concurrent [nom=" + nom + ", prenom=" + prenom
				+ ", nationalite=" + nationalite + "]";
	}
}
