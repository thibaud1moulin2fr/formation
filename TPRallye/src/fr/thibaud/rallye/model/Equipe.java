package fr.thibaud.rallye.model;


public class Equipe {
	private String nom, nationalite;
	private boolean constructeur;
	private int equipageIndex = 0;
	private Equipage[] equipages = new Equipage[3];
	public Equipe(String nom, String nationalite, boolean constructeur) {
		super();
		this.nom = nom;
		this.nationalite = nationalite;
		this.constructeur = constructeur;
	}
	public void ajouterEquipage(Equipage equipage){
		if(equipageIndex < 3){
			equipages[equipageIndex] = equipage;
			equipageIndex++;
		}
	}
	public String infosEquipe() {
		String equipagesStr = "";
		for(Equipage equipage : equipages){
			if(equipage != null){
				equipagesStr += "\n" + equipage.infosEquipage();
			}
		}
		return "Equipe [nom=" + nom + ", nationalite=" + nationalite
				+ ", constructeur=" + constructeur + ", equipageIndex="
				+ equipageIndex + ", \nequipages=" + equipagesStr
				+ "]";
	}
	public Equipage getEquipage(int dossard){
		for(Equipage equipage : this.equipages){
			if(equipage.getDossard() == dossard) return equipage;
		}
		return null;
	}
}
