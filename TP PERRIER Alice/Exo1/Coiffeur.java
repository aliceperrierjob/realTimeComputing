package Exo1;
public class Coiffeur extends Thread{

    private int tempsCoiffure = 5;
    public Coiffeur (){
        this.start();
    }

    public void run(){
        while (true){
            try {
                Main.SemClient.acquire();
                Main.mutex.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Main.NbClientAttente -=1;
            Main.mutex.release();
            System.out.println("Un client se fait coiffer");
            try {
                sleep(tempsCoiffure * 1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }            
            Main.mutexCoiffeur.release();      
        }
            
    }
}
