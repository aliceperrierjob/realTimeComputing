package Exo1;
import java.util.Random;

public class Client extends Thread {
    private int id;

    public Client(int id) {
        this.id = id;
        this.start();
    }

    public void run(){
        int tempsSommeil = new Random().nextInt(10);
        try {
	        sleep(tempsSommeil * 1000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		    e.printStackTrace();
        }
            System.out.println("Je suis le client " + this.id + " et j'arrive au salon de coiffure");
            try {
                Main.mutex.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (Main.NbClientAttente < Main.NbChaises){
                Main.NbClientAttente +=1;
                Main.SemClient.release();
                Main.mutex.release();
                try {
                    Main.mutexCoiffeur.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Je suis le client " +this.id+ " et je sors du salon coiffé");
            }
            else {
                Main.mutex.release();
                System.out.println("Je suis le client " +this.id+ " et je sors du salon  pas coiffé");
            }
            
        }
}
