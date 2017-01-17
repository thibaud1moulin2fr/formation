package fr.thibaud.command.bo;

public class Panier {
	private float montant;
	private int indexLigne;
	private LignePanier[] lignePaniers;

	public Panier() {
		super();
		this.lignePaniers = new LignePanier[20];
	}
	
	public float getMontant() {
		return this.montant;
	}
	public LignePanier getLigne(int index) {
		if(lignePaniers.length > index) {
			return lignePaniers[index];
		}
		return null;
	}
	public LignePanier[] getLignePaniers() {
		return lignePaniers;
	}
	public void addLigne (Article article, int qte) {
		if ((article.getQteStock() - qte) > 0) {
			if (lignePaniers != null && indexLigne < lignePaniers.length) {
				lignePaniers[indexLigne] = new LignePanier(article, qte);
				indexLigne++;
				
			}
		}
	}
	public void updateLigne (int index, int newQte) {
		if (index < lignePaniers.length && lignePaniers[index] != null) {
			if ((lignePaniers[index].getArticle().getQteStock() - newQte) > 0) {
				lignePaniers[index].setQte(newQte);
			}
		}
	}

	@Override
	public String toString() {
		String listeLignePaniers = null;
		for (LignePanier a : lignePaniers) if (a != null) listeLignePaniers += a.toString() + "\n";
		return "Panier [montant=" + montant + ", indexLigne=" + indexLigne + ", \nlignePaniers="
				+ listeLignePaniers + "]";
	}
}
