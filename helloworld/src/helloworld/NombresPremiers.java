package helloworld;


public class NombresPremiers {
	public static void main(String[] args) {
		boolean b = false;
		String resultStr = "2";
		for(int i = 2; i < 1000; i++){
			for (int j = i - 1; j > 1; j--){
				if((i%j) != 0){
					b = true;
					break;
				}
			}
			if(!b){
				resultStr += " " + String.valueOf(i);
				b = false;
			}
		}
		System.out.println("Liste des nombres premiers inférieurs à 1000 : " + resultStr);
	}

}
