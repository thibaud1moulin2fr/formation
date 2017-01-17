package fr.thibaud.command.bo;
public class LignePanier extends Ligne {
	public LignePanier(Article article, int qte) {
		super(article, qte);
	}

	public void setQte (int qte) {
		super.setQte(qte);
	}
}
