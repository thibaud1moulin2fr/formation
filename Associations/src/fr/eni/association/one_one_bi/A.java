/**
 * 
 */
package fr.eni.association.one_one_bi;

/**
 * @author bmartin
 *
 */
public class A {
	private B b;
	
	public B getB() { 
		return( b );
	}
	
	public void setB( B newb ) { 
		B oldb = this.b;
		this.setLocalB( newb ); // A se connecte à son nouveau b
		if( newb != null ){
		  if ( newb.getA() != null ) {   // si b est déjà connecté à un autre A
			  newb.getA().setLocalB(null);    // cet autre A doit se déconnecter
		  }
		  newb.setLocalA( this ); // et le newb se connecte à son A
		}
		if (oldb!=null) oldb.setLocalA(null); //l'ancien B se deconnecte de ce A
	}
	
	void setLocalB(B newb){
		this.b = newb;
	}
	
}
