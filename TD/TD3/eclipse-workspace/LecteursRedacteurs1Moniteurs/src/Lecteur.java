import java.util.Random;

public class Lecteur extends Thread {
	
	private int id;
	private int tempsSommeil;
	
	Livre livre;

	public Lecteur(int i, Livre livre) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.livre = livre;
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
			livre.lecture(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
