package fr.thibaud.gestionparking.model;

public class Voiture {
	private Integer idVoiture;
	private String nom, pI;
	private Personne personne;

	public Voiture() {
		super();
		personne = new Personne();
	}

	public Voiture(String nom, String pI) {
		super();
		this.nom = nom;
		this.pI = pI;
		personne = new Personne();
	}

	public Voiture(Integer idVoiture, String nom, String pI) {
		super();
		this.idVoiture = idVoiture;
		this.nom = nom;
		this.pI = pI;
		personne = new Personne();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getpI() {
		return pI;
	}

	public void setpI(String pI) {
		this.pI = pI;
	}

	public Integer getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Integer idVoiture) {
		this.idVoiture = idVoiture;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", nom=" + nom + ", pI=" + pI + "]";
	}

}
