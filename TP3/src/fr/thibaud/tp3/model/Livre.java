/**
 * 
 */
package fr.thibaud.tp3.model;

import java.util.Date;

/**
 * @author Administrateur
 *
 */
public class Livre extends Produit {

	private Editeur editeur;
	/**
	 * @param titre
	 * @param dateSortie
	 * @param prixAchat
	 * @param auteur
	 */
	public Livre(String titre, Date dateSortie, float prixAchat, Auteur auteur, Editeur editeur) {
		super(titre, dateSortie, prixAchat, auteur);
		this.editeur = editeur;
	}

	/* (non-Javadoc)
	 * @see fr.thibaud.tp3.model.Produit#getPrixVente()
	 */
	@Override
	public float getPrixVente() {
		// TODO Auto-generated method stub
		return (float) (super.getPrixAchat() * 1.25);
	}

	/* (non-Javadoc)
	 * @see fr.thibaud.tp3.model.Produit#getPrixVente(float)
	 */
	@Override
	public float getPrixVente(float pourcentageReduction) {
		// TODO Auto-generated method stub
		return getPrixVente() * (1 - pourcentageReduction);
	}

	@Override
	public String toString() {
		return "Livre [editeur=" + editeur + ", getPrixVente()="
				+ getPrixVente() + ", toString()=" + super.toString() + "]";
	}

}
