/**
 * 
 */
package fr.eni.association.one_many_composition;

/**
 * @author bmartin
 *
 */
public class B {
	private int data;
	
	public B(int data){
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public final int getData() {
		return data;
	}

	public void dispose(){
		//éventuellement ce B se déconnecte de son A
	}
}
