/**
 * 
 */
package fr.thibaud.tp3.model;

/**
 * @author Administrateur
 *
 */
public abstract class Personne {

	private String siteWeb;
	/**
	 * 
	 */
	public Personne() {
	}
	public Personne(String siteWeb) {
		super();
		this.siteWeb = siteWeb;
	}
	@Override
	public String toString() {
		return "Personne [siteWeb=" + siteWeb + "]";
	}
}
