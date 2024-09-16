package Exo1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static Semaphore SemClient = new Semaphore(0);
    public static Semaphore mutexCoiffeur = new Semaphore(0);
    public static Semaphore mutex = new Semaphore(1);
    public static int NbChaises = 2; 
    public static int NbClientAttente = 0; 
    

    public static void main(String[] args) {
       Coiffeur coiffeur = new Coiffeur();
       for (int i = 1; i < 6; i ++){
        Client client = new Client(i);
       } 
    }
}
