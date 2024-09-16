package ProducteurConsommateur;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Producteur extends Thread 
{
    public static LinkedList<Integer> fifo = new LinkedList<Integer>();
    public static Semaphore plein = new Semaphore(10);
    public static Semaphore vide = new Semaphore(0);

    public Producteur() {
        this.start();
    }

    public void run(){
       while(true){
       try {
            plein.acquire();
       } catch (Exception e) {
        e.printStackTrace();
       }
    System.out.println("Le producteur se réveille après t secondes de sommeil et commence à produire");
    vide.release();
    }
}
    
}
