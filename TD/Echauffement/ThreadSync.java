package Echauffement;
import java.util.Random;

public class ThreadSync extends Thread {
    private int id; 
    public static int compteur = 0;
    public static int verrou = 0;
    public static int turn = new Random().nextInt(4) + 1;

    public ThreadSync(int id) {
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
        while(turn != this.id) {}
        System.out.println("Je suis le thread " + this.id);
        compteur +=1;
        System.out.println("Le nombre de thread exécutés depuis le début est " + compteur);
        turn = this.id%4 + 1;
    
    }


}
