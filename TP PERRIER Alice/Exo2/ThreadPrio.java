package Exo2;

import java.util.Date;

public class ThreadPrio extends Thread {
    private int cycle = 100; 

    public ThreadPrio(int prio){
        this.setPriority(prio);
        this.start();
    }

    public void run(){
        Date date = new Date();
        long tempsDebut = date.getTime();
        for(int i = 0; i<100; i++){
            try {
                this.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Date date1 = new Date();
        long tempsFin = date1.getTime();
        long tempsExecution = tempsFin - tempsDebut;

        System.out.println("Mon nom : " + this.getName()+ ", ma priorité : " + this.getPriority() + ", temps début : "+ tempsDebut +" temps fin : " + tempsFin);
    }

}
