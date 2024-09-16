import java.util.Random;
import java.util.concurrent.Semaphore;

public class Lecteur extends Thread {
	
    private FichierPartage fichier = new FichierPartage();
	private int id;
	private int tempsSommeil;
	public static int nl = 0;

   
	public Lecteur(int i, boolean ressourceLibreEcriture) {
		// TODO Auto-generated constructor stub
		this.id = i;
	}
	
	public void run() {
		
		tempsSommeil = new Random().nextInt(10);
		try {
			sleep(tempsSommeil * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Arrivée du lecteur " + id + ".");
		
		fichier.allouerRessource();		
		nl++;
		/*if (nl == 1) { try {
			mutexr.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }
		
		mutexl.release();
		*/
		System.out.println("Je suis le lecteur " + id + " et je commence la lecture.");
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Je suis le lecteur " + id + " et j'ai termin� la lecture.");
		
		fichier.libererRessource();
		
		nl--;
		if (nl == 0) { mutexr.release(); }
		fichier.libererRessource();
		
	}

    public synchronized void allouerRessource(){
        while(!ressourceLibreLecture) {
            try { wait (); }
            catch ( InterruptedException e) { e. printStackTrace (); }
            };
            ressourceLibreLecture = false ;
    }

    public synchronized void libererRessource(){
        ressourceLibreLecture = true;
        notify();
    }



}
