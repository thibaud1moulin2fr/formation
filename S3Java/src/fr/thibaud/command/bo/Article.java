package fr.thibaud.command.bo;

import java.io.Serializable;

public abstract class Article implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reference;
	private String marque;
	private String designation;
	private float prixUnitaire;
	private int qteStock;
	
	public String getReference() {
		return reference;
	}
	protected void setReference(String reference) {
		if (reference != null && !reference.trim().equals("")) this.reference = reference;
	}
	public String getMarque() {
		return marque;
	}
	protected void setMarque(String marque) {
		if (marque != null && !marque.trim().equals("")) this.marque = marque;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		if (designation != null && !designation.trim().equals("")) this.designation = designation;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		if (prixUnitaire >= 0) this.prixUnitaire = prixUnitaire;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		if (qteStock >= 0) this.qteStock = qteStock;
	}
	
	protected void entrerStock(int qte) {
		
	}
	protected void sortirStock(int qte) {
		
	}
	
	@Override
	public String toString() {
		return "Article [reference=" + reference + ", marque=" + marque + ", designation=" + designation
				+ ", prixUnitaire=" + prixUnitaire + ", qteStock=" + qteStock + "]";
	}
}
