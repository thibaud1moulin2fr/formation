package fr.thibaud.tp1.object;

public class Client {
	private String adresse, nom, prenom, ville;
	private int cp;
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) throws Exception {
		if(nom != null && !nom.trim().isEmpty()){
			this.nom = nom.toUpperCase();			
		}else{
			throw new Exception("nom nul ou vide");
		}
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = Client.firstInUpper(prenom, "-");
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = Client.firstInUpper(ville, " ");
	}
	public String getCp() {
		return String.valueOf(cp);
	}
	public void setCp(String cp) throws Exception {
		try{
			if(Integer.valueOf(cp) >= 1000 && Integer.valueOf(cp) < 100000){
				this.cp = Integer.valueOf(cp);
			}else{
				throw new Exception("CP doit être compris entre 1 000 et 99 999");
			}
		}catch(NumberFormatException nfe){
			throw new Exception("CP doit être compris entre 1 000 et 99 999");
		}
	}
	public Client(String adresse, String nom, String prenom, String ville,
			String cp) throws Exception {
		super();
		this.setAdresse(adresse);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setVille(ville);
		this.setCp(cp);
	}
	@Override
	public String toString() {
		return "Client [adresse=" + getAdresse() + ", nom=" + getNom() + ", prenom="
				+ getPrenom() + ", ville=" + getVille() + ", cp=" + getCp() + "]";
	}
	private static String firstInUpper(String chaine, String separateur){
		String[] tableau = chaine.split(separateur);
		chaine = "";
		for(int i = 0; i < tableau.length; i++){
			if(i > 0) chaine += separateur;
			chaine += tableau[i].substring(0, 1).toUpperCase() + tableau[i].substring(1).toLowerCase();
		}
		return chaine;
	}
}
