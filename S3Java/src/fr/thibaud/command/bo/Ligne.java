package fr.thibaud.command.bo;
public abstract class Ligne {
	protected int qte;
	protected float prix;
	private Article article;
	public Ligne(Article article, int qte) {
		super();
		this.article = article;
		this.setQte(qte);
	}
	public int getQte() {
		return qte;
	}
	protected void setQte(int qte) {
		this.qte = qte;
		this.prix = qte * this.getArticle().getPrixUnitaire();
		this.getArticle().setQteStock(this.getArticle().getQteStock() - qte);
	}
	public float getPrix() {
		return prix;
	}
	public Article getArticle() {
		return article;
	}
	protected void setArticle(Article article) {
		this.article = article;
	}
	@Override
	public String toString() {
		return "Ligne [qte=" + qte + ", prix=" + prix + ", article=" + article + "]";
	}
}
