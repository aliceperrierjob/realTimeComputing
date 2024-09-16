import java.util.concurrent.Semaphore;

public class Lecteur extends Thread {

    private int index;
    public static Semaphore ecrire = new Semaphore(0);
    public static Semaphore lecture = new Semaphore(5);
    public static int compteur = 0;
    
    public Lecteur(int index) {
        this.index = index;
        this.start();
    }

    public void run(){
        try {
            lecture.acquire();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        compteur +=1;
        if (compteur == 1){
            try {
                ecrire.acquire();
            }
            catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        System.out.println("Arrivée du lecteur " + this.index);
        System.out.println("Je suis le lecteur " + this.index + " et je commence la lecture.");
        try {
            sleep(5);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("Je suis le lecteur " + this.index + " et j'ai terminé la lecture.");

        lecture.release();
        compteur = compteur - 1;
        if( compteur == 0){
            ecrire.release();
        }
        
    }
}