package fr.thibaud.command.bo;

import java.util.List;

public class Catalogue {
	
	private List<Article> articles;
	
	public Catalogue(List<Article> articles) {
		super();
		this.articles = articles;
	}
	public List<Article> getArticlesAuCatalogue() {
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
