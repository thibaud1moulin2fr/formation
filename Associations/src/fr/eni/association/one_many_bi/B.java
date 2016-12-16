/**
 * 
 */
package fr.eni.association.one_many_bi;


/**
 * @author bmartin
 *
 */
public class B {
	private A a;

	public A getA() {
		return (a); 
	}
	
	void setLocalA(A newa){
		this.a = newa;
	}
	
	public void setA(A newa){ 		
		if (newa != null){
			Boolean find = false;
			for (B rb : newa.getArray()) { //B est-il déjà référencé par ce A
				if (rb==null) break;
				if (rb.equals(this)) {
					find = true;
					break;
				}
			}
			if( !find ){ 
				if (a != null) 	 // si b est déjà connecté à un A
					a.removeB(this); // cet autre B doit se déconnecter
				this.setLocalA(newa);
				a.addB(this); //ajouter ce B à son A
			}
		}
	}
}
