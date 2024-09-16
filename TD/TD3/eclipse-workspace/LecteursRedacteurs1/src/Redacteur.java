import java.util.Random;
import java.util.concurrent.Semaphore;

public class Redacteur extends Thread {
	
	private int id;
	private int tempsSommeil;
	
	public Semaphore mutexr;

	public Redacteur(int i, Semaphore mutexr) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.mutexr = mutexr;
	}
	
	public void run() {
		
		tempsSommeil = new Random().nextInt(10);
		try {
			sleep(tempsSommeil * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Arriv�e du r�dacteur " + id + ".");
		
		try {
			mutexr.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Je suis le r�dacteur " + id + " et je commence l'�criture.");
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Je suis le r�dacteur " + id + " et j'ai termin� l'�criture.");
		
		mutexr.release();
	}

}
