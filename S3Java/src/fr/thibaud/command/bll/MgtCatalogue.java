package fr.thibaud.command.bll;

import java.util.List;
import java.util.Scanner;

import fr.thibaud.command.bo.Article;
import fr.thibaud.command.bo.Catalogue;
import fr.thibaud.command.bo.Ramette;
import fr.thibaud.command.bo.Stylo;
import fr.thibaud.command.dal.memory.ArticleMemory;

public class MgtCatalogue {
	public static void Visualiser () {
		List<Article> articles = ArticleMemory.selectAll();
		if (articles != null) {
			Catalogue catalogue = new Catalogue(articles);
			System.out.println(catalogue.toString());
		}
	}
	public static boolean Ajouter () {
		Article article = null;
		String temoinString = "", marque, ref, designation, couleur;
		float temoinFloat = (float) 0.0, pu = (float) 0.0;
		int temoinInt = 0, qte = 0, grammage = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String buffer = null;
		System.out.println("L'article est une Ramette ou un Stylo ? (R/S)");
		buffer = scanner.nextLine();
		if (buffer.trim().toUpperCase().equals("R")) {
			System.out.println("----------\nRamette\n----------");
			System.out.println("marque");
			buffer = scanner.nextLine();
			marque = (String) tryWrite(temoinString, buffer);
			System.out.println("ref");
			buffer = scanner.nextLine();
			ref = (String) tryWrite(temoinString, buffer);
			System.out.println("designation");
			buffer = scanner.nextLine();
			designation = (String) tryWrite(temoinString, buffer);
			System.out.println("pu");
			buffer = scanner.nextLine();
			pu = (Float) tryWrite(temoinFloat, buffer);
			System.out.println("qte");
			buffer = scanner.nextLine();
			qte = (Integer) tryWrite(temoinInt, buffer);
			System.out.println("grammage");
			buffer = scanner.nextLine();
			grammage = (Integer) tryWrite(temoinInt, buffer);
			article = new Ramette(marque, ref, designation, pu, qte, grammage);
		} else if (buffer.trim().toUpperCase().equals("S")){
			System.out.println("----------\nStylo\n----------");
			System.out.println("marque");
			buffer = scanner.nextLine();
			marque = (String) tryWrite(temoinString, buffer);
			System.out.println("ref");
			buffer = scanner.nextLine();
			ref = (String) tryWrite(temoinString, buffer);
			System.out.println("designation");
			buffer = scanner.nextLine();
			designation = (String) tryWrite(temoinString, buffer);
			System.out.println("pu");
			buffer = scanner.nextLine();
			pu = (Float) tryWrite(temoinFloat, buffer);
			System.out.println("qte");
			buffer = scanner.nextLine();
			qte = (Integer) tryWrite(temoinInt, buffer);
			System.out.println("couleur");
			buffer = scanner.nextLine();
			couleur = (String) tryWrite(temoinString, buffer);
			article = new Stylo(marque, ref, designation, pu, qte, couleur);
		} else {
			System.out.println("Mauvaise entrée.");
			return false;
		}
		ArticleMemory.insert(article);
		return true;
	}
	public static void exporter () {
		
	}
	private static Object tryWrite (Object type, String buffer) {
		if (buffer != null) {
			if (type instanceof String && !buffer.trim().isEmpty()) {
				return buffer;
			}
			if (type instanceof Float) {
				return Float.parseFloat(buffer);
			}
			if (type instanceof Integer) {
				return Integer.parseInt(buffer);
			}
		}
		System.out.println("Mauvaise entrée.");
		return null;
	}
}
