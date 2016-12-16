/**
 * 
 */
package fr.eni.association.one_many_composition;


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
	
	public void addB(int data) throws RuntimeException{
		//A se charge d'instancier le B
		B newb = new B(data);
		
		//évitons les doublons....
		Boolean find = false;
		for (B rb : tabB) {
			if (rb==null) break;
			if (rb.getData()==newb.getData()) {
				find = true;
				break;
			}
		}
		//ajoutons le à la fin du tableau s'il reste de la place
		if( !find ) {
			try{
				tabB[position] = newb; //ce A référence un newb supplémentaire
				position++;
			} catch(ArrayIndexOutOfBoundsException e){
				throw new RuntimeException("Le tableau de B semble plein !");
			}
		}
	}
	
	public void removeB(int data){
		B[] newRb = new B[MAXI];
		int pos = 0;
		for (B rb : tabB) {
			if (rb==null) break;
			//on recopie dans le nouveau tableau tout sauf b
			if (rb.getData()!=data){
				newRb[pos] = rb;
				pos++;
			} else rb.dispose(); //Le B supprimé est détruit
		}
		tabB = newRb;
		position = pos;
	}
	
	
	private boolean disposed = false;
	public void dispose(){
		if(!disposed){
			//Le A pense à détruire ses B
	         if(tabB!=null)
	             for(B rb : tabB) {
	            	 if (rb==null) break;
	            	 rb.dispose();
	             }
	         tabB = null;
	         disposed=true;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		if (!disposed) dispose();
	}

	
	public B[] getArray(){
		return tabB;
	}
}
