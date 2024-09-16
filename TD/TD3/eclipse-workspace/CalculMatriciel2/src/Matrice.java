
public class Matrice {
	
	public int N, i, j;
	public double k;
	double M[][];
	public String name;

	public Matrice(int N, String name) {
		// TODO Auto-generated constructor stub
		this.N = N;
		this.name = name;
		M = new double[N][N];
	}
	
	public void remplir(int i, int j, double k) {
		M[i][j] = k;
	}
	
	public void afficher() {
		System.out.println(name);
		int N = M[0].length; 		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(M[i][j] + " \t"); 
            }
            System.out.println();
        }
		System.out.println();
	}
	
	public double get(int i, int j) {
		return M[i][j];
	}

}
