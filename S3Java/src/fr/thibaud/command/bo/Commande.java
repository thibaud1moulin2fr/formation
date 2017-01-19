/**
 * 
 */
package fr.thibaud.command.bo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Eni Ecole
 *
 */
public class Commande {
    private String numero;
    private String nomClient;
    private Date dateCommande;
    private float montant;

    private Map<Integer,LigneCommande> lignesCommande;


    /**
     * Créer une commande vide possedant un numéro
     * @param numero
     * @param nom
	 * @param dateCommande
	 * @param montant
     * @throws Exception 
     */
    public Commande(String numero, String nom, Date dateCommande, float montant) throws Exception {
		setNumero(numero);
    	setNomClient(nom);
    	setDateCommande(dateCommande);
    	this.montant = montant;
		lignesCommande = new HashMap<Integer,LigneCommande>();
    }
     
    /**
     * Créer une commande à partir d'un panier. Le numéro est généré
     * @param panier
     * @param nom
     * @throws Exception 
     */
    public Commande(Panier panier, String nom) throws Exception {
    	setNumero(generateNumero());
    	setNomClient(nom);
    	setDateCommande(new Date());
    	//transformer les lignes du panier en lignes de commande. En profiter pour les numéroter
    	lignesCommande = new HashMap<Integer,LigneCommande>();
    	int numero = 1;
    	for (LignePanier ligne : panier.getLignePaniers()) {
			lignesCommande.put(numero, new LigneCommande(numero, ligne));
			numero++;
    	}
    }
    
    
    /**
	 * @return the numero
	 */
	public final String getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 * @throws Exception 
	 */
	private final void setNumero(String numero) throws Exception {
		if (validNumero(numero))
			this.numero = numero;
	}


	/**
	 * @return the nomClient
	 */
	public final String getNomClient() {
		return nomClient;
	}


	/**
	 * @param nomClient the nomClient to set
	 */
	private final void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	/**
	 * @return the montant
	 */
	public final float getMontant() {
		montant = 0;
		Iterator<Integer> iterator = getIteratorLignes();
		while (iterator.hasNext()) {
			LigneCommande lc = getLigne(iterator.next());
			montant += lc.getPrix();
		}
		return montant;
	}


	/**
	 * @return the dateCommande
	 */
	public Date getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande the dateCommande to set
	 */
	private void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the lignesCommande
	 */
	public final Map<Integer,LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	private final Iterator<Integer> getIteratorLignes(){
		Iterator<Integer> iterator = this.lignesCommande.keySet().iterator();
		return iterator;
	}

	/**
	 * @param lignesCommande the lignesCommande to set
	 */
	public final void setLignesCommande(Map<Integer,LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}


	private static boolean validNumero(String numero) throws Exception{
		boolean ok = true;
		
		String expression = "([0-9]{4}-[0-9]{2}-[0-9]{2}-[0-9]{9})";
		if (!numero.matches(expression)){
			ok = false;
			throw new Exception("Le numero de commande ne respecte pas le format imposé !");
		}
		return ok;
	}
	
	private static String generateNumero(){
		Date dateNow = new Date();

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd-hhmmssS");
		String date_to_string = dateformat.format(dateNow);
		return date_to_string;

	}
    
    public final LigneCommande getLigne(int numero) {
		
 		return lignesCommande.get(numero);
     }

    
    /**
     * Présenter le détail de la commande
     */
    @Override
    public String toString() {
		StringBuffer bf =new StringBuffer();
		bf.append("Nom du client  : " + getMontant() + "\n");
		bf.append("Commande : " + getNumero() + "\n");
		bf.append("Date : " + getDateCommande() + "\n\n");
		Iterator<Integer> iterator = getIteratorLignes();
		while (iterator.hasNext()) {
			LigneCommande lc = getLigne(iterator.next());
			bf.append("ligne " + lc.toString()
								+ "\n");
		}
		bf.append("\nMontant : " + getMontant());
		bf.append("\n\n");
		return bf.toString();
    }
    
    

//    
//    /**
//     * Tester le clonage
//     * @param newClient
//     * @param newDate
//     * @param newArticle
//     */
//    public void unitTestClone_modif(String newClient, Date newDate, Article newArticle){
//    	nomClient = newClient;
//    	numero = generateNumero();
//    	dateCommande = newDate;
//		Iterator<Integer> iterator = getIteratorLignes();
//		if (iterator.hasNext()) {
//			int numero = iterator.next();
//			LigneCommande lc = getLigne(numero);
//			lc.setArticle(newArticle);
//			lc.setQte(4);
//		}
//    	
//    }
    

}
