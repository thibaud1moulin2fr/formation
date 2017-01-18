package fr.thibaud.command.bo;
public class Ramette extends Article {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int grammage;
	public Ramette (String marque, String ref, String designation, float pu, int grammage) {
		super();
		super.setDesignation(designation);
		super.setMarque(marque);
		super.setPrixUnitaire(pu);
		super.setReference(ref);
		this.grammage = grammage;
	}
	public Ramette (String marque, String ref, String designation, float pu, int qte, int grammage) {
		super();
		super.setDesignation(designation);
		super.setMarque(marque);
		super.setPrixUnitaire(pu);
		super.setReference(ref);
		super.setQteStock(qte);
		this.grammage = grammage;
	}
	public int getGrammage() {
		return grammage;
	}
	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}
	@Override
	public String toString() {
		return "Ramette [grammage=" + grammage + ",\n\t" + super.toString() + "]";
	}
}
