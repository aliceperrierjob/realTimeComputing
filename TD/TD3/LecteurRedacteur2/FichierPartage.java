public class FichierPartage {

    public static int nbLec = 0;
    public static int nbEcr = 0;

    private boolean ressourceLibre = true;

    public synchronized void allouerRessource() {
        while (!ressourceLibre){
            try { wait();}
            catch ( InterruptedException e) { e. printStackTrace (); }
        };
        ressourceLibre = false ;
    }

    public synchronized void libererRessource() {
        ressourceLibre = true;
        notify();
    }
    
}
