package fr.thibaud.command.bo;
import java.util.Arrays;

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
		return "Catalogue [articles=" + Arrays.toString(articles) + "]";
	}
}
