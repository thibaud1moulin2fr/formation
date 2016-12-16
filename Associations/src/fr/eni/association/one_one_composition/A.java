/**
 * 
 */
package fr.eni.association.one_one_composition;

/**
 * @author bmartin
 *
 */
public class A {
	private B b;
	
	public A(int data){
		//A construit l'instance de son B
		B newb = new B(data);
		this.b = newb;
	}

}
