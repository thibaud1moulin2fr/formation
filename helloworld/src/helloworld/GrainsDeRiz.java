package helloworld;


public class GrainsDeRiz {

	public static void main(String[] args) {
		long result = 1;
		int size = 8;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				result += 2 * result;
			}
		}
		System.out.println("Nombre de grains de riz sur l'échiquier : " + Long.valueOf(result));
	}

}
