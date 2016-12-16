/**
 * 
 */
package fr.eni.testsAssociations;

import java.util.Scanner;


/**
 * @author bmartin
 *
 */
public class TestsAssociation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test Association one-one-unidirectionnelle (A --> [0..1] B)
		//***********************************************************
		fr.eni.association.one_one_uni.A a_t1_1 = new fr.eni.association.one_one_uni.A();
		fr.eni.association.one_one_uni.B b_t1_1 = new fr.eni.association.one_one_uni.B();
		a_t1_1.setB(b_t1_1);
		
		System.out.println("Test Association one-one-unidirectionnelle (A --> [0..1] B)");
		System.out.println("***********************************************************");
		System.out.println(String.format("a: %s b: %s a->b: %s", ValueString(a_t1_1), ValueString(b_t1_1), ValueString(a_t1_1.getB())));
		
		
		
		//Test Association one-one-bidirectionnelle (A [0..1] <--> [0..1] B)
		//******************************************************************
		//A l'affectation d'un B à A, il faut :
		//- A se connecte à son newb et ce newb se connecte à son A
		//- si newb est déjà connecté à un autre A, cet autre A doit se déconnecter
		//- l'ancien b est déconnecté du A
		fr.eni.association.one_one_bi.A a_t2_1 = new fr.eni.association.one_one_bi.A();
		fr.eni.association.one_one_bi.B b_t2_1 = new fr.eni.association.one_one_bi.B();
		a_t2_1.setB(b_t2_1);
		System.out.println("");
		System.out.println("Test Association one-one-bidirectionnelle (A [0..1] <--> [0..1] B)");
		System.out.println("******************************************************************");
		System.out.println(String.format("a: %s b: %s a->b: %s b->a: %s", ValueString(a_t2_1), ValueString(b_t2_1), ValueString(a_t2_1.getB()), ValueString(b_t2_1.getA())));
		System.out.println("------------------------------------------------------------------");
		
		//affectation d'un nouveau B à A
		fr.eni.association.one_one_bi.B b_t2_2 = new fr.eni.association.one_one_bi.B();
		a_t2_1.setB(b_t2_2);
		System.out.println(String.format("a: %s newb: %s a->newb: %s newb->a: %s", ValueString(a_t2_1), ValueString(b_t2_2), ValueString(a_t2_1.getB()), ValueString(b_t2_2.getA())));
		System.out.println(String.format("oldb: %s oldb->a: %s", ValueString(b_t2_1), ValueString(b_t2_1.getA())));
		System.out.println("------------------------------------------------------------------");
		
		//affectation B null à A
		a_t2_1.setB(null);
		System.out.println(String.format("a: %s newb: %s a->newb: %s newb->a: %s", ValueString(a_t2_1), ValueString(b_t2_2), ValueString(a_t2_1.getB()), ValueString(b_t2_2.getA())));
		System.out.println(String.format("oldb: %s oldb->a: %s", ValueString(b_t2_2), ValueString(b_t2_2.getA())));
		System.out.println("------------------------------------------------------------------");
		
		
		
		//Test Association one-many-unidirectionnelle (A --> [0..*] B)
		//************************************************************
		fr.eni.association.one_many_uni.A a_t3_1 = new fr.eni.association.one_many_uni.A();
		fr.eni.association.one_many_uni.B b_t3_1 = new fr.eni.association.one_many_uni.B();
		fr.eni.association.one_many_uni.B b_t3_2 = new fr.eni.association.one_many_uni.B();
		fr.eni.association.one_many_uni.B b_t3_3 = new fr.eni.association.one_many_uni.B();
		try{
			a_t3_1.addB(b_t3_1);
			a_t3_1.addB(b_t3_2);
			a_t3_1.addB(b_t3_3);
			System.out.println("");
			System.out.println("Test Association one-many-unidirectionnelle (A --> [0..*] B)");
			System.out.println("************************************************************");
			System.out.println(String.format("a: %s a->b*: %s", ValueString(a_t3_1), ValuesString(a_t3_1.getArray())));
			System.out.println("------------------------------------------------------------------");
			a_t3_1.removeB(b_t3_2);
			System.out.println(String.format("a: %s a->b*: %s", ValueString(a_t3_1), ValuesString(a_t3_1.getArray())));
			System.out.println("------------------------------------------------------------------");
			
		}catch(RuntimeException e){
			System.err.println(e.getMessage());
		}
		
		
		//Test Association one-many-bidirectionnelle (A [0..1] <--> [0..*] B)
		//******************************************************************
		fr.eni.association.one_many_bi.A a_t4_1 = new fr.eni.association.one_many_bi.A();
		fr.eni.association.one_many_bi.B b_t4_1 = new fr.eni.association.one_many_bi.B();
		fr.eni.association.one_many_bi.B b_t4_2 = new fr.eni.association.one_many_bi.B();
		fr.eni.association.one_many_bi.B b_t4_3 = new fr.eni.association.one_many_bi.B();
		fr.eni.association.one_many_bi.B b_t4_4 = new fr.eni.association.one_many_bi.B();
		try{
			//en ajoutant des b à a (a référence ses nouveaux b et chaque b référence le a)
			a_t4_1.addB(b_t4_1);
			a_t4_1.addB(b_t4_2);
			a_t4_1.addB(b_t4_3);
			
			//en associant un a à un b (b référence le a et le a ajoute ce nouveau b)
			b_t4_4.setA(a_t4_1);
			
			System.out.println("");
			System.out.println("Test Association one-many-bidirectionnelle (A [0..1] <--> [0..*] B)");
			System.out.println("*******************************************************************");
			System.out.println(String.format("a: %s a->b*: %s", ValueString(a_t4_1), ValuesString(a_t4_1.getArray())));
			System.out.println(String.format("b->a: %s", ValueString(b_t4_1.getA())));
			System.out.println(String.format("b->a: %s", ValueString(b_t4_2.getA())));
			System.out.println(String.format("b->a: %s", ValueString(b_t4_3.getA())));
			System.out.println(String.format("b->a: %s", ValueString(b_t4_4.getA())));
			System.out.println("------------------------------------------------------------------");
			
			a_t4_1.removeB(b_t4_2);
			System.out.println(String.format("a: %s a->b*: %s", ValueString(a_t4_1), ValuesString(a_t4_1.getArray())));
			System.out.println(String.format("b: %s b->a: %s", ValueString(b_t4_2),ValueString(b_t4_2.getA())));
			System.out.println("------------------------------------------------------------------");
			
		}catch(RuntimeException e){
			System.err.println(e.getMessage());
		}
		
		
		//Les agrégations s'implémentent comme les associations.
		//Une composition peut s'implémenter comme une association unidirectionnelle. Simplement la classe mere gere le cycle de vie de 
		//ses instances filles
		
		
		System.out.println("Appuyez sur entrée pour sortir du test...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}
	
	
	private static String ValueString(Object o){
		return  (o!=null ? String.valueOf(o.hashCode()): "null");
	}
	
	private static String ValuesString(Object[] os){
		StringBuffer valuesTabB = new StringBuffer();
		for (Object o : os) {
			if (o==null) break;
			valuesTabB.append(String.valueOf(o.hashCode())).append("-");
		}
		return valuesTabB.toString();
	}
	
	
}
