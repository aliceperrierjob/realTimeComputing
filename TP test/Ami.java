import java.util.Random;
import java.util.concurrent.Semaphore;

public class Ami extends Thread {
    
    private int id;
    private int tempsSommeil;
    public static Semaphore SId = new Semaphore (0);

    public Ami (int id){
        this.id = id;
        this.start();
    }

    public void run(){
        tempsSommeil = new Random().nextInt(10);
        try {
			sleep(tempsSommeil * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Je suis l'ami "+ this.id+" en route");
        for (int i = 0; i<100; i++){
            if (i != this.id){
            Main.semaphores.get(i).release();
            }
        }
        /*switch (this.id) {
            case 1:
                Main.S2.release();
                Main.S3.release();
                break;
            case 2:
                Main.S1.release();
                Main.S3.release();
                break;
            case 3: 
                Main.S1.release();
                Main.S2.release();
                break;*/
        try {
            for (int i = 0; i<100-1; i++){
                Main.semaphores.get(this.id).acquire();
            }
        }
        catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        System.out.println("Je suis l'ami "+this.id+ " et je suis arrivée au cinéma");

 
}}


/*switch (this.id) {
            case 1:
                Main.S1.acquire();
                Main.S1.acquire();
                break;
            case 2:
                Main.S2.acquire();
                Main.S2.acquire();
                break;
            case 3: 
                Main.S3.acquire();
                Main.S3.acquire();
                break;*/
