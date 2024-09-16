package Echauffement;
public class ThreadId extends Thread {
    private int id; 
    public static int compteur = 0;

    public ThreadId(int id) {
        this.id = id;
        this.start();
    }

    /*
    public void run(){
        System.out.println("Je suis le thread " + this.id);
        System.out.println("C'est encore moi, le thread "+ this.id);
    }*/

    
    public void run(){
        System.out.println("Je suis le thread " + this.id);
        compteur +=1;
        System.out.println("Le nombre de thread exécutés depuis le début est " + compteur);
    }

}
