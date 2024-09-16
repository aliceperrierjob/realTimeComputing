import java.util.Random;
import java.util.concurrent.Semaphore;

public class Redacteur extends Thread {
	
	private int id;
	private int tempsSommeil;
	public static int nr = 0;
	
	public Semaphore mutexr;
	public Semaphore mutexl2;
	public static Semaphore mutexr2 = new Semaphore(1);

	public Redacteur(int i, Semaphore mutexr, Semaphore mutexl2) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.mutexr = mutexr;
		this.mutexl2 = mutexl2;
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
			mutexr2.acquire();
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		nr++;
		if (nr == 1) { try {
			mutexl2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		mutexr2.release();
		
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
		
		try {
			mutexr2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nr--;
		if (nr == 0) { mutexl2.release(); }
		
		mutexr2.release();
		
	}

}

