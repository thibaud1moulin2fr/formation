package fr.thibaud.tp3.model;

import java.util.Date;

public abstract class Produit {

	private String titre;
	private Date dateSortie;
	private float prixAchat;
	private Auteur auteur;
	
	public Produit(String titre, Date dateSortie, float prixAchat, Auteur auteur) {
		super();
		this.titre = titre;
		this.dateSortie = dateSortie;
		this.prixAchat = prixAchat;
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Produit [titre=" + titre + ", dateSortie=" + dateSortie
				+ ", prixAchat=" + prixAchat + ", auteur=" + auteur + "]";
	}

	public abstract float getPrixVente();
	
	//return prixAchat * (1 - pourcentageReduction);
	public abstract float getPrixVente(float pourcentageReduction);

	protected final float getPrixAchat() {
		return prixAchat;
	}
	
}
