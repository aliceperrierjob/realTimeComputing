
public class Calcul extends Thread {
	
	public Matrice A, B, C;
	private int iStart, iEnd, jStart, jEnd;
	

	public Calcul(Matrice A, Matrice B, Matrice C, int iStart, int iEnd, int jStart, int jEnd) {
		// TODO Auto-generated constructor stub
		this.A = A;
		this.B = B;
		this.C = C;
		this.iStart = iStart;
		this.iEnd = iEnd;
		this.jStart = jStart;
		this.jEnd = jEnd;
		this.start();
	}
	
	public void run() {
		for (int i = iStart ; i < iEnd ; i++ ) {
			for (int j = jStart ; j < jEnd ; j++) {
				C.remplir(i,  j,  A.get(i,  j) + B.get(i,  j));
			}
		}
	}

}
