/**
 * 
 */
package fr.thibaud.tp3.model;

/**
 * @author Administrateur
 *
 */
public class Auteur extends Personne {

	private String nom, prenom, twitter;
	/**
	 * @param siteWeb
	 */
	public Auteur(String nom, String prenom, String twitter, String siteWeb) {
		super(siteWeb);
		this.nom = nom;
		this.prenom = prenom;
		this.twitter = twitter;
	}

	public Auteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + prenom + ", twitter="
				+ twitter + ", toString()=" + super.toString() + "]";
	}
}
