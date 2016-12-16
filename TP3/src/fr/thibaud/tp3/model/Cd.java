/**
 * 
 */
package fr.thibaud.tp3.model;

import java.util.Date;

/**
 * @author Administrateur
 *
 */
public class Cd extends Produit {

	private Piste[] pistes = new Piste[15];
	private int indexPiste = 0;
	/**
	 * @param titre
	 * @param dateSortie
	 * @param prixAchat
	 * @param auteur
	 */
	public Cd(String titre, Date dateSortie, float prixAchat, Auteur auteur) {
		super(titre, dateSortie, prixAchat, auteur);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.thibaud.tp3.model.Produit#getPrixVente()
	 */

	@Override
	public float getPrixVente() {
		// TODO Auto-generated method stub
		return (float) (super.getPrixAchat() * 1.20);
	}

	/* (non-Javadoc)
	 * @see fr.thibaud.tp3.model.Produit#getPrixVente(float)
	 */
	@Override
	public float getPrixVente(float pourcentageReduction) {
		// TODO Auto-generated method stub
		return getPrixVente() * (1 - pourcentageReduction);
	}
	public void addPiste(int numero, String intitule, Date duree){
		if(intitule != null && duree != null){
			pistes[indexPiste] = new Piste(numero, intitule, duree);
			indexPiste++;
		}
	}

	@Override
	public String toString() {
		String pistesString = "";
		for(Piste piste : pistes){
			if(piste != null){
				pistesString += "\n" + piste.toString();
			}
		}
		return "Cd [pistes=" + pistesString + ", indexPiste="
				+ indexPiste + ", getPrixVente()=" + getPrixVente()
				+ ", toString()=" + super.toString() + "]";
	}
}
