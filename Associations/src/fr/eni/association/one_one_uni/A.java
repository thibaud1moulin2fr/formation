/**
 * 
 */
package fr.eni.association.one_one_uni;

/**
 * @author bmartin
 *
 */
public class A {
	//la classe A référence une instance de la classe B
	private B b;
	
	//recupérer la référence du B associée à A
	public B getB(){
		return b;
	}
	
	//changer la référence du B associée à A
	public void setB( B newb ) {
		if( newb != null ) {
			this.b=newb; //ce A connecte son newb
		}
	}
}
