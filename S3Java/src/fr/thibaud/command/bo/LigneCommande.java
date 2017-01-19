/**
 * 
 */
package fr.thibaud.command.bo;

/**
 * @author Eni Ecole
 * Une ligne de commande est numérotée
 */
public class LigneCommande extends Ligne{
    //une ligne de commande est numérotée
	private int numero;

    public LigneCommande(int numero, Article article, int qte, float prix) {
		super(article,qte);
		this.setPrix(prix);
    	this.setNumero(numero);

    }
    
    public LigneCommande(int numero, LignePanier lignePanier) {
		super(lignePanier.getArticle(),lignePanier.getQte());
		this.setPrix(lignePanier.getPrix());
    	this.setNumero(numero);

    }
    
    /**
	 * @return the numero
	 */
	public final int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	private final void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @param prix the prix to set
	 */
	private final void setPrix(float prix) {
		this.prix = prix;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ligne [numero=");
		builder.append(getNumero());
		builder.append(super.toString());
		return builder.toString();
	}
	
}
