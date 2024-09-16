package Echauffement;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadSem extends Thread {
    private int id; 
    public static int compteur = 0;
    public static Semaphore s = new Semaphore(1);

    public ThreadSem(int id) {
        this.id = id;
        this.start();
    }

    /*
    public void run(){
        while(verrou == 1) {}
        verrou = 1;
        System.out.println("Je suis le thread " + this.id);
        compteur +=1;
        System.out.println("Le nombre de thread exécutés depuis le début est " + compteur);
        verrou = 0;
    
    } */

    public void run(){
        try {
            s.acquire();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("Je suis le thread " + this.id);
        compteur +=1;
        System.out.println("Le nombre de thread exécutés depuis le début est " + compteur);
        s.release();
        
    }


}
