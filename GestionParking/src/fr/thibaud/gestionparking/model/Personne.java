package fr.thibaud.gestionparking.model;

/**
 * Represente une personne.
 * 
 * 
 * @author Administrateur
 *
 */
public class Personne {
	private Integer idPersonne;
	private String nom, prenom;

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom) {
		this();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(Integer idPersonne, String nom, String prenom) {
		this(nom,prenom);
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
