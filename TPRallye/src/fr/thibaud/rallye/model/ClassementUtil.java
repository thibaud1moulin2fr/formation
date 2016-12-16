package fr.thibaud.rallye.model;

import java.util.Date;

public class ClassementUtil {

	public static Resultat[] classerParTemps(Resultat[] resultats){
		Resultat[] nouveauxResultats = new Resultat[resultats.length];
		for(int i = 0; i < resultats.length; i++){
			Date temps = new Date();
			int position = 0;
			for(int j = 0; j < resultats.length; j++){
				if (resultats[j] != null && resultats[j].getTemps().compareTo(temps) < 0){
					temps = resultats[j].getTemps();
					position = j;
				}
			}
			nouveauxResultats[i] = resultats[position];
			resultats[position] = null;
		}
		return nouveauxResultats;
	}
	public static Classement[] classerParTemps(Classement[] classements){
		Classement[] nouveauxClassement = new Classement[classements.length];
		for(int i = 0; i < classements.length; i++){
			Date temps = new Date();
			int position = 0;
			for(int j = 0; j < classements.length; j++){
				if (classements[j] != null && classements[j].getCumulTemps().compareTo(temps) < 0){
					temps = classements[j].getCumulTemps();
					position = j;
				}
			}
			nouveauxClassement[i] = classements[position];
			classements[position] = null;
		}
		return nouveauxClassement;
	}
	public static Resultat[] classerParEquipage(Resultat[] resultats){
		Resultat[] nouveauxResultats = new Resultat[resultats.length];
		for(int i = 0; i < resultats.length; i++){
			int dossard = 0;
			int position = 0;
			for(int j = 0; j < resultats.length; j++){
				if (resultats[j] != null && resultats[j].getEquipage().getDossard() == dossard){
					dossard = resultats[j].getEquipage().getDossard();
					position = j;
				}
			}
			nouveauxResultats[i] = resultats[position];
			resultats[position] = null;
		}
		return nouveauxResultats;
	}
}
