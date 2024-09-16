package ProducteurConsommateur;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Consommateur extends Thread{

    public static LinkedList<Integer> fifo = new LinkedList<Integer>();
    public static Semaphore vide = new Semaphore(0);
    public static Semaphore plein = new Semaphore(10);
    
    public Consommateur() {
        this.start();
    }

    public void run(){
        while(true){
            try {
                 vide.acquire();
            } catch (Exception e) {
             e.printStackTrace();
            }
            System.out.println("Le consommateur se réveille après t secondes de sommeil et commence à consommer");
            //Integer x = fifo.removeFirst();
            //System.out.println("Le consommateur à consommé l'élèment "+ x);
            plein.release();
         }
        
    }
    
    
}
