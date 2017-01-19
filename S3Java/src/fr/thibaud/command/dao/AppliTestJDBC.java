/**
 * 
 */
package fr.thibaud.command.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fr.thibaud.command.bo.Article;
import fr.thibaud.command.bo.Catalogue;
import fr.thibaud.command.bo.Panier;
import fr.thibaud.command.bo.Ramette;
import fr.thibaud.command.bo.Stylo;

/**
 * @author Eni Ecole
 * 
 */
public class AppliTestJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// JDBC : Tester la connexion
		Connection cnx = null;
		try {
			cnx = PoolConnection.getConnection();
			if (cnx != null && !cnx.isClosed()) 
				System.out.println("JDBC : Connexion ouverte");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		PoolConnection.closeConnection();		
		
		//Définir la couche DAL utilisée
		Repository<Article> articleRepository = new ArticleDAO();
		
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("REM : Création d'articles en base\n");
		System.out.println("---------------------------------------------------------------");
		
		Stylo unBic =null;
		Ramette uneRamette = null;
		// JDBC : Ajouter les articles dans la base
		try {
			// Creation de nouveaux articles
			unBic = new Stylo("Bic", "BBOrange","Bic bille Orange", (float)1.2, 20, "Bleu");
			uneRamette = new Ramette("Clairef", "CRA4S", "Ramette A4 Sup", (float)9, 20, 80);
			
			articleRepository.insert(unBic);
			articleRepository.insert(uneRamette);

			// de même pour ces articles supplémentaires
			Stylo unStylo = null;
			unStylo = new Stylo("Stypen", "PlumeS", "Stylo Plume Stypen", (float)5.5, 20, "jaune");
			articleRepository.insert(unStylo);

			unStylo = new Stylo("Waterman", "WOBGreen", "Waterman Orion Bille vert",(float)5.5, 20, "vert");
			articleRepository.insert(unStylo);

			unStylo = new Stylo("Parker", "PlumeP", "Stylo Plume Parker", (float)5.5, 5, "noir");
			articleRepository.insert(unStylo);

			unStylo = new Stylo("Bic",  "BBBlack","Bic bille noir", (float) 5.0, 10, "noir");
			articleRepository.insert(unStylo);
			
		} catch (Exception e) {
			System.err.println("JDBC(ERREUR) : Ajout Article " + e.getMessage());
		}
		
		// JDBC : extraire les articles de la base et les placer dans le catalogue
		Catalogue catalogue = null;
		try {
			catalogue = new Catalogue(articleRepository.selectAll());
			System.out.println("JDBC : catalogue chargé");
			System.out.println("---------------------------------------------------------------");
			System.out.println("REM : Affichage du Catalogue\n"+catalogue.toString());
			System.out.println("---------------------------------------------------------------");
		} catch (Exception e) {
			System.err.println("JDBC(ERREUR) : Catalogue " + e.getMessage());
		}
		
			
		System.out.println("---------------------------------------------------------------");		
		System.out.println("REM : Suppression/Modification d'un article en base : \n");
		System.out.println("---------------------------------------------------------------");	
		try {
			articleRepository.delete(unBic);
			System.out.println("REM : Article supprimé (" + unBic.toString()+")");
			uneRamette.setDesignation("Ramette A4 Sup modifiée");
			uneRamette.setQteStock(99);
			articleRepository.update(uneRamette);
		} catch (Exception e) {
			System.err.println("JDBC(ERREUR) : " + e.getMessage());
		}
		
		// JDBC : extraire les articles de la base et les placer dans le catalogue
		try {
			catalogue = new Catalogue(articleRepository.selectAll());
			System.out.println("---------------------------------------------------------------");
			System.out.println("REM : Affichage du Catalogue après modif/suppression en base\n"+catalogue.toString());
			System.out.println("---------------------------------------------------------------");
		} catch (Exception e) {
			System.err.println("JDBC(ERREUR) : Catalogue " + e.getMessage());
		}

		//************************
		//constitution d'un Panier
		//************************
		Panier panier = new Panier();
		try {
			panier.addLigne(catalogue.getArticlesAuCatalogue().get(0), 2);
			panier.addLigne(catalogue.getArticlesAuCatalogue().get(1), 4);
			panier.addLigne(catalogue.getArticlesAuCatalogue().get(2), 1);
		} catch (Exception e) {
			System.err.println("ERREUR : " + e.getMessage());
		}
/*		
		//Définir la couche DAL utilisée
		Repository<Commande> commandeRepository = new CommandeDAO();
		
		// JDBC : test de l'insertion d'une nouvelle commande et des lignes associées
		try{
			Commande cde = new Commande(panier,"Edmond BOSAPIN");
			commandeRepository.insert(cde);
			System.out.println("---------------------------------------------------------------");
			System.out.println("REM : Commande insérée ");
			System.out.println("---------------------------------------------------------------");
		}catch (Exception e) {
			System.err.println("JDBC(ERREUR) : Commande " + e.getMessage());
		}
		
		// JDBC : test de l'extraction d'une commande et des lignes associées
		try {
			Commande cde = commandeRepository.selectById("2015-03-06-011823573");
			System.out.println("---------------------------------------------------------------");
			System.out.println("REM : Affichage de la commande\n" + cde.toString());
			System.out.println("---------------------------------------------------------------");
		} catch (Exception e) {
			System.err.println("JDBC(ERREUR) : Commande " + e.getMessage());
		}
		
*/
		
	}

}
