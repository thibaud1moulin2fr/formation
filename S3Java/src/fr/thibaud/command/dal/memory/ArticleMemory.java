package fr.thibaud.command.dal.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import fr.thibaud.command.bo.Article;
import fr.thibaud.command.dal.binary.Serialiseur;

public class ArticleMemory {
	private final static File file = new File("C:/Users/Administrateur/Desktop/catalogue.dat");
	public static Article[] selectAll() {
		Article[] articles = null;
		Object obj = null;
		
		if (!file.exists()) return articles;
		try {
			obj = Serialiseur.deserialiser(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (obj != null) {
			articles = (Article[]) obj;
		}
		return articles;
	}
	public static void insert (Article article) {
		OutputStream os = null;
		Article[] articles = null;
		Article[] newArticles = null;
		int size = 0;
		articles = selectAll();
		size = (articles != null) ? articles.length : 0;
		try {
			os = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newArticles = new Article[size + 1];
		newArticles[size] = article;
		Serialiseur.serialiser(newArticles, os);
	}
}
