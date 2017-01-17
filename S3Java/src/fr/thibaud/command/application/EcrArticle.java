package fr.thibaud.command.application;

import fr.thibaud.command.bo.Stylo;
import fr.thibaud.command.dal.memory.ArticleMemory;

public class EcrArticle {

	public static void main(String[] args) {
//		Stylo stylo = new Stylo("Waterman", "A441", "Stylo à encre", (float) 12.56, "noir");
//		ArticleMemory.insert(stylo);
		Stylo stylo = (Stylo) ArticleMemory.selectAll()[0];
		System.out.println(stylo.toString());
	}
}
