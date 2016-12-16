package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Morpion {
	
	private static int tailleGrille = 4;
	private static byte[][] grille = new byte[tailleGrille][tailleGrille];
	
	public static void main(String[] args) {
		boolean autrePartie = true;
		while(autrePartie){
			boolean fini = false;
			initGrille();
			afficheGrille();
			byte ligne, colonne, tour = 1;
			while(!fini){
				//Numéro du joueur sachant le numéro du tour
				byte numJoueur = (byte) (((tour - 1) % 2) + 1); 
				//valeur cachée correnpondant au joueur
				byte valJoueur = (byte) ((numJoueur == 1) ? 1 : -1);
				//Choix des coordonnées
				do{
					System.out.println("Joueur " + numJoueur);
					do{
						System.out.println("Ligne ? ");
						ligne = litValeur();
					}while (ligne == -1);
					do{
						System.out.println("Colonne ? ");
						colonne = litValeur();
					}while (colonne == -1);
				}while (existeDeja(ligne, colonne, valJoueur));
				//Vérification de l'avancement du jeux
				if(ligneHorizontaleComplete(ligne)){
					System.out.println("Joueur " + numJoueur + " gagne : ligne " + ligne + 1);
					fini = true;
				}else if(ligneVerticaleComplete(colonne)){
					System.out.println("Joueur " + numJoueur + " gagne : colonne " + colonne + 1);
					fini = true;
				}else if(ligneDiagonaleDescComplete()){
					System.out.println("Joueur " + numJoueur + " gagne : diagonale descendante ");
					fini = true;
				}else if(ligneDiagoAscComplete()){
					System.out.println("Joueur " + numJoueur + " gagne : diagonale ascendante ");
					fini = true;
				}else if(tour == tailleGrille * tailleGrille){
					fini = true;
				}
				tour++;
				afficheGrille();
			}
			autrePartie = faireAutrePartie();
		}
	}

	private static boolean faireAutrePartie() {
		String autrePartie = null;
		System.out.println("Nouvelle partie ? (O/n)");
		BufferedReader saisie = new BufferedReader (new InputStreamReader(System.in));
		try {
			autrePartie = saisie.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(autrePartie.toUpperCase().equals("O")){
			return true;
		}
		return false;
	}

	private static void afficheGrille() {
		for(byte[] ligne : grille){
			String grilleStr = "";
			for(byte valJoueur : ligne){
				grilleStr += (valJoueur == -1) ? 2 + " " : valJoueur + " ";
			}
			System.out.println(grilleStr);
		}
	}

	private static void initGrille(){
		for(int i = 0; i < tailleGrille; i++){
			for(int j = 0; j < tailleGrille; j++){
				grille[i][j] = 0;
			}
		}
	}
	
	private static boolean ligneHorizontaleComplete(byte i){
		byte ligne = 0;
		for(int j = 0; j < tailleGrille; j++){
			ligne += grille[i][j];
		}
		if(ligne == tailleGrille || ligne == -tailleGrille){
			return true;
		}
		return false;
	}
	
	private static boolean ligneVerticaleComplete(byte j){
		byte ligne = 0;
		for(int i = 0; i < tailleGrille; i++){
			ligne += grille[i][j];
		}
		if(ligne == tailleGrille || ligne == -tailleGrille){
			return true;
		}
		return false;
	}
	
	private static boolean ligneDiagonaleDescComplete(){
		byte ligne = 0;
		for(int i = 0, j = 0; i < tailleGrille; i++, j++){
			ligne += grille[i][j];
			if(ligne == tailleGrille || ligne == -tailleGrille){
				return true;
			}
		}
		return false;
	}
	
	private static boolean ligneDiagoAscComplete(){
		byte ligne = 0;
		for(int i = 0, j = tailleGrille - 1; i < tailleGrille; i++, j--){
			ligne += grille[i][j];
			if(ligne == tailleGrille || ligne == -tailleGrille){
				return true;
			}
		}
		return false;
	}
	
	private static byte litValeur(){
		BufferedReader saisie;
		saisie=new BufferedReader (new InputStreamReader(System.in));
		String buffer = null;
		byte position = 0;
		try {
			buffer=saisie.readLine();
			position = Byte.parseByte(buffer);
		} catch (IOException | NumberFormatException a) {
			System.out.println("Erreur de saisie : Chiffre attendu.");
		}
		if(!(position > 0 && position < tailleGrille + 1)){
			if(position == 0) System.out.println("Erreur de saisie : Chiffre en dehors des limites (de 1 à " + tailleGrille + ").");
			return - 1;
		}
		return (byte) (position - 1);
	}
	
	private static boolean existeDeja(byte i, byte j, byte joueur){
		if(grille[i][j] != 0){
			System.out.println("Erreur de saisie : Coordonnées déjà existantes.");
			return true;
		}else{
			grille[i][j] = joueur;
		}
		return false;
	}
}
