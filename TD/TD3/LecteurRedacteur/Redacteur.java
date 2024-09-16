import java.util.concurrent.Semaphore;

public class Redacteur extends Thread {
    private int index;
    
    public static Semaphore ecrire = new Semaphore(1);
    
    public Redacteur(int index) {
        this.index = index;
        this.start();
    }

    public void run(){
        try {
            ecrire.acquire();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("Arrivée du rédacteur " + this.index);
        System.out.println("Je suis le rédacteur " + this.index + " et je commence l'écriture.");
        try {
            sleep(5);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("Je suis le rédacteur " + this.index + " et j'ai terminé l'écriture.");
        ecrire.release();
    }
}
