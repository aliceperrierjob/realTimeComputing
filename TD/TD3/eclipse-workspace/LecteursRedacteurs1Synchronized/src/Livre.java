
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

	public void debutLecture() throws InterruptedException {
		// TODO Auto-generated method stub
		while (nbRed > 0) {
			Thread.sleep(100);
		}
		incrementerLec();
	}

	public void finLecture() {
		// TODO Auto-generated method stub
		decrementerLec();
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

	public void debutEcriture() throws InterruptedException {
		// TODO Auto-generated method stub
		while (nbLec + nbRed > 0) {
			Thread.sleep(100);
		}
		incrementerRed();
	}

	public void finEcriture() {
		// TODO Auto-generated method stub
		decrementerRed();
	}
	
	private synchronized void incrementerLec() {
		// TODO Auto-generated method stub
		nbLec++;
		
	}

	private synchronized void decrementerLec() {
		// TODO Auto-generated method stub
		nbLec--;
	}
	
	private synchronized void incrementerRed() {
		// TODO Auto-generated method stub
		nbRed++;
		
	}

	private synchronized void decrementerRed() {
		// TODO Auto-generated method stub
		nbRed--;
	}

}
