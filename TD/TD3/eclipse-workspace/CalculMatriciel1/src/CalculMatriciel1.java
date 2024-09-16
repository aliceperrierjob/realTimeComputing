
public class CalculMatriciel1 {
	
	public static int N = 10;
	
	public static void main(String[] args) {
		
		Matrice A = new Matrice(N, "Matrice A");
		Matrice B = new Matrice(N, "Matrice B");
		Matrice C = new Matrice(N, "Matrice C");
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				A.remplir(i, j, 1);
				B.remplir(i,  j,  i * N + j);
				C.remplir(i,  j,  A.get(i,  j) + B.get(i,  j));
			}
		}
		
		A.afficher();
		B.afficher();
		C.afficher();
		
	}

}
