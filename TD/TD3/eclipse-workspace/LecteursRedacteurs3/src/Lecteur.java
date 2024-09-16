import java.util.Random;
import java.util.concurrent.Semaphore;

public class Lecteur extends Thread {
	
	private int id;
	private int tempsSommeil;
	public static int nl = 0;
	
	public Semaphore mutexr;
	public Semaphore mutex;
	public static Semaphore mutexl = new Semaphore(1);

	public Lecteur(int i, Semaphore mutexr, Semaphore mutex) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.mutexr = mutexr;
		this.mutex = mutex;
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
		
		try {
			mutex.acquire();
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			mutexl.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		nl++;
		if (nl == 1) { try {
			mutexr.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }
		
		mutexl.release();
		
		mutex.release();
		
		System.out.println("Je suis le lecteur " + id + " et je commence la lecture.");
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Je suis le lecteur " + id + " et j'ai terminé la lecture.");
		
		try {
			mutexl.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		nl--;
		if (nl == 0) { mutexr.release(); }
		
		mutexl.release();
		
	}

}

