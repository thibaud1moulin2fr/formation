package fr.thibaud.command.dal.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.thibaud.command.bo.Article;
import fr.thibaud.command.dal.binary.Serialiseur;

public class ArticleMemory {
	private final static File file = new File("C:/Users/Administrateur/Desktop/catalogue.dat");
	@SuppressWarnings("unchecked")
	public static List<Article> selectAll() {
		List<Article> articles = null;
		Object obj = null;
		
		if (!file.exists()) return articles;
		try {
			obj = Serialiseur.deserialiser(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (obj != null) {
			articles = (ArrayList<Article>) obj;
		}
		return articles;
	}
	public static void insert (Article article) {
		OutputStream os = null;
		List<Article> articles = null;
		List<Article> newArticles = null;
		articles = selectAll();
		if (article != null) articles.add(article);
		try {
			os = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Serialiseur.serialiser(newArticles, os);
	}
}
