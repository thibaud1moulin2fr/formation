package fr.thibaud.command.bo;

public class Catalogue {
	
	private Article[] articles;

	public Catalogue(Article[] articles) {
		super();
		this.articles = articles;
	}
	public Article[] getArticlesAuCatalogue() {
		return this.articles;
	}
	
	@Override
	public String toString() {
		StringBuilder listeArticles = new StringBuilder(), tmp = null;
		for (Article a : articles) if (a != null) {
			tmp = new StringBuilder();
			tmp.append(a.toString()); tmp.append("\n");
			listeArticles.append(tmp);
		}
		return "Catalogue [articles=\n" + listeArticles + "]";
	}
}
