/**
 * 
 */
package fr.thibaud.tp3.model;

/**
 * @author Administrateur
 *
 */
public class Editeur extends Personne {

	private String nomGroupe, adresse;
	/**
	 * @param siteWeb
	 */
	public Editeur(String nomGroupe, String adresse, String siteWeb) {
		super(siteWeb);
		this.nomGroupe = nomGroupe;
		this.adresse = adresse;
		// TODO Auto-generated constructor stub
	}
	public Editeur(String nomGroupe, String adresse) {
		super();
		this.nomGroupe = nomGroupe;
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Editeur [nomGroupe=" + nomGroupe + ", adresse=" + adresse
				+ ", toString()=" + super.toString() + "]";
	}

}
