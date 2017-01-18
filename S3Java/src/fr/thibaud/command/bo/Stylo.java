package fr.thibaud.command.bo;
public class Stylo extends Article {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String couleur;
	public Stylo (String marque, String ref, String designation, float pu, String couleur) {
		super();
		super.setDesignation(designation);
		super.setMarque(marque);
		super.setPrixUnitaire(pu);
		super.setReference(ref);
		this.couleur = couleur;
	}
	public Stylo (String marque, String ref, String designation, float pu, int qte, String couleur) {
		super();
		super.setDesignation(designation);
		super.setMarque(marque);
		super.setPrixUnitaire(pu);
		super.setReference(ref);
		super.setQteStock(qte);
		this.couleur = couleur;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	@Override
	public String toString() {
		return "Stylo [couleur=" + couleur + ",\n\t" + super.toString() + "]";
	}
}
