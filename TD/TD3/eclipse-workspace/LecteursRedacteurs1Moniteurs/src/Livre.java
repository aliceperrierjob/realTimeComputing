
public class Livre {
	
	private int nbLec = 0;
	private int nbRed = 0;
	
	public void lecture(int id) throws InterruptedException {
		// TODO Auto-generated method stub
		
		debutLecture();
		
		System.out.println("Je suis le lecteur " + id + " et je commence la lecture.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Je suis le lecteur " + id + " et j'ai terminé la lecture.");
		
		finLecture();
		
	}
	
	public synchronized void debutLecture() throws InterruptedException {
		// TODO Auto-generated method stub
		while (nbRed != 0) {
			wait();
		}
		nbLec++;
	}

	public synchronized void finLecture() {
		// TODO Auto-generated method stub
		nbLec--;
		if (nbLec == 0) { notifyAll(); }
	}


	public void ecriture(int id) throws InterruptedException {
		// TODO Auto-generated method stub
		
		debutEcriture();
		
		System.out.println("Je suis le rédacteur " + id + " et je commence l'écriture.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Je suis le rédacteur " + id + " et j'ai terminé l'écriture.");
		
		finEcriture();
		
	}

	public synchronized void debutEcriture() throws InterruptedException {
		// TODO Auto-generated method stub
		while (nbLec + nbRed != 0) {
			wait();
		}
		nbRed++;
	}

	public synchronized void finEcriture() {
		// TODO Auto-generated method stub
		nbRed--;
		notifyAll();
	}
	
}
