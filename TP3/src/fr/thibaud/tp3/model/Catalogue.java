/**
 * 
 */
package fr.thibaud.tp3.model;

/**
 * @author Administrateur
 *
 */
public class Catalogue {

	private Produit[] produits = new Produit[50];
	private int indexCatalogue = 0;
	
	public Produit[] extract(){
		return produits;
	}
	public Produit[] extract(Produit produit){
		Produit[] nouveauxProduits = new Produit[produits.length];
		int indexNouveauxProduits = 0;
		for(Produit nouveauProduit : produits){
			if(nouveauProduit != null && nouveauProduit.equals(produit)){
				nouveauxProduits[indexNouveauxProduits] = nouveauProduit;
				indexNouveauxProduits++;
			}
		}
		return nouveauxProduits ;
	}
	public void add(Produit produit){
		if(produit != null){
			produits[indexCatalogue] = produit;
			indexCatalogue++;
		}
	}
	public Produit get(int index){
		if(index >= 0 && index < 50) return produits[index];
		return null;
	}
}
