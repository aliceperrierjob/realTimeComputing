import java.util.concurrent.Semaphore;

public class LecteursRedacteurs4 {
	
	public static int nbLec = 5;
	public static int nbRed = 2;
	
	public static Semaphore mutexr = new Semaphore(1);
	public static Semaphore mutexl2 = new Semaphore(1);
	
	public static void main(String[] args) {
		
		for (int i = 0 ; i < nbLec ; i++) {
			new Lecteur(i + 1, mutexr, mutexl2).start(); 
		}
		
		for (int i = 0 ; i < nbRed ; i++) {
			new Redacteur(i + 1, mutexr, mutexl2).start(); 
		}
	}

}
