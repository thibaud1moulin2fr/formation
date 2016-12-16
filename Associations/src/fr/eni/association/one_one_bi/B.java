/**
 * 
 */
package fr.eni.association.one_one_bi;

/**
 * @author bmartin
 *
 */
public class B {
	private A a;
	
	public void setA( A newa ) { 
		A olda = this.a;
		this.setLocalA( newa );	// B se connecte à son nouveau a
		if( newa != null ){
		  if ( newa.getB() != null ) {   // si a est déjà connecté à un autre B
			  newa.getB().setLocalA(null);    // cet autre B doit se déconnecter
		  }
		  newa.setLocalB( this ); // et le newa se connecte à son B
		}
		if (olda!=null) olda.setLocalB(null); //l'ancien A se deconnecte de ce B
	}
	
	void setLocalA(A newa){
		this.a = newa;
	}
	
	public A getA(){ 
		return(a); 
	}
}
