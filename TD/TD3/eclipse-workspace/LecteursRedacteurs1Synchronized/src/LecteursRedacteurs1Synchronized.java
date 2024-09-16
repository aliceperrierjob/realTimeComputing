
public class LecteursRedacteurs1Synchronized {

	public static int nbLec = 5;
	public static int nbRed = 2;
	
	public static void main(String[] args) {
		
		Livre livre = new Livre();
		
		for (int i = 0 ; i < nbLec ; i++) {
			new Lecteur(i + 1, livre).start(); 
		}
		
		for (int i = 0 ; i < nbRed ; i++) {
			new Redacteur(i + 1, livre).start(); 
		}
	}

}
