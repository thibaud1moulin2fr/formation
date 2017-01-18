package fr.thibaud.command.application;

import java.util.Scanner;

import fr.thibaud.command.bll.MgtCatalogue;

public class EcrArticle {

	public static void main(String[] args) {
		boolean continuer = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String buffer = null;
		System.out.println("Articles aucatalogue\n");
		while (continuer) {
			MgtCatalogue.Visualiser();
			System.out.println("\nAjouter (A) - Quitter (Q)\n");
			buffer = scanner.nextLine();
			if (buffer != null && buffer.trim().toUpperCase().equals("A")) {
				MgtCatalogue.Ajouter();
			} else if (buffer != null && buffer.trim().toUpperCase().equals("Q")) {
				continuer = false;
			} else {
				System.out.println("Mauvaise entrée (A/Q)");
			}
		}
	}
}
