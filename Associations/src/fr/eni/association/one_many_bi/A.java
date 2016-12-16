/**
 * 
 */
package fr.eni.association.one_many_bi;





/**
 * @author bmartin
 *
 */
public class A {
	
	//Cette gestion sera facilité par l'utilisation d'une collection
	//à la place du tableau
	private B[] tabB;
	private final int MAXI = 10;
	private int position;
	
	public A() { 
		tabB = new B[MAXI];
		position=0;
	}
	
	public void addB(B newb) throws RuntimeException {
		
		//évitons les doublons....
		Boolean find = false;
		for (B rb : tabB) {
			if (rb==null) break;
			if (rb.equals(newb)) {
				find = true;
				break;
			}
		}
		//ajoutons le à la fin du tableau s'il reste de la place
		if( !find ){ 
			if (newb.getA()!=null) 		   // si b est déjà connecté à un A
				newb.getA().removeB(newb);  // cet autre A doit se déconnecter
			newb.setLocalA(this);
			try{
				tabB[position] = newb; //ce A référence un newb supplémentaire
				position++;
			} catch(ArrayIndexOutOfBoundsException e){
				throw new RuntimeException("Le tableau de B semble plein !");
			}
		}
	}
	
	public B[] getArray() {
		return tabB;
	}
	
	public void removeB(B b){
		B[] newRb = new B[MAXI];
		int pos = 0;
		for (B rb : tabB) {
			if (rb==null) break;
			//on recopie dans le nouveau tableau tout sauf b
			if (!rb.equals(b)){
				newRb[pos] = rb;
				pos++;
			} else rb.setLocalA(null); //le B supprimé doit se deconnecter de ce A
		}
		tabB = newRb;
		position = pos;
	}

}
