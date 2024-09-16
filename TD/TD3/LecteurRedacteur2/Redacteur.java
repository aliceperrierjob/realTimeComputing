import java.util.Random;
import java.util.concurrent.Semaphore;

public class Redacteur extends Thread {
	
	private int id;
	private int tempsSommeil;
	
	public boolean ressourceLibreEcriture;

	public Redacteur(int i, Semaphore mutexr) {
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
		
		System.out.println("Arrivée du rédacteur " + id + ".");
		
		allouerRessource();
		
		System.out.println("Je suis le rédacteur " + id + " et je commence l'écriture.");
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Je suis le rédacteur " + id + " et j'ai terminé l'écriture.");
		
		libererRessource();
	}

    public synchronized void allouerRessource(){
        while(!ressourceLibreEcriture) {
            try { wait (); }
            catch ( InterruptedException e) { e. printStackTrace (); }
            };
            ressourceLibreEcriture = false ;
    }

    public synchronized void libererRessource(){
        ressourceLibreEcriture = true;
        notify();
    }

}
