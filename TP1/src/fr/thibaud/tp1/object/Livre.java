package fr.thibaud.tp1.object;

public class Livre {
	private String titre, auteur;
	private int nbpages;
	private long isbn;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) throws Exception {
		if(auteur != null && !auteur.trim().isEmpty()){
			this.auteur = auteur;
		}else{
			throw new Exception("Auteur doit être renseigné");
		}
	}
	public int getNbpages() {
		return nbpages;
	}
	/**
	 * 
	 * @param nbpages
	 * @throws Exception
	 */
	public void setNbpages(int nbpages) throws Exception {
		if(nbpages > 0){
			this.nbpages = nbpages;			
		}else{
			throw new Exception("Nombre de pages doit-être strictement positif");
		}
	}
	public String getIsbn() {
		return String.valueOf(isbn).substring(0, 3) 
				+ "-" + String.valueOf(isbn).substring(3, 4) 
				+ "-" + String.valueOf(isbn).substring(4, 8) 
				+ "-" + String.valueOf(isbn).substring(8, 12) 
				+ "-" + String.valueOf(isbn).substring(12);
	}
	/**
	 * 
	 * @param isbn
	 * @throws Exception
	 */
	public void setIsbn(String isbn) throws Exception {
		if(isbn != null && isbn.replace("-", "").length() >= 13){
			this.isbn = Long.valueOf(isbn.replace("-", ""));
		}else{
			throw new Exception("ISBN doit contenir au moins 13 chiffres en plus des séparateurs");
		}
	}
	public Livre(String titre, String auteur, int nbpages, String isbn) throws Exception {
		super();
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setNbpages(nbpages);
		this.setIsbn(isbn);
	}
	@Override
	public String toString() {
		return "Livre [titre=" + getTitre() + ", auteur=" + getAuteur() + ", nbpages="
				+ getNbpages() + ", isbn=" + getIsbn() + "]";
	}
	public Double getPrix(){
		return this.nbpages * 0.05 + 10;
	}
}
