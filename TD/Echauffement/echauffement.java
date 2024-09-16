package Echauffement;
public class echauffement {
    public static void main(String[] args) throws InterruptedException {
       /* ThreadId thread1 = new ThreadId(1);
        ThreadId thread2 = new ThreadId(2);
        ThreadId thread3 = new ThreadId(3);
        ThreadId thread4 = new ThreadId(4);*/

        /*ThreadSync thread1 = new ThreadSync(1);
        ThreadSync thread2 = new ThreadSync(2);
        ThreadSync thread3 = new ThreadSync(3);
        ThreadSync thread4 = new ThreadSync(4);     */   
        
        ThreadSem thread1 = new ThreadSem(1);
        ThreadSem thread2 = new ThreadSem(2);
        ThreadSem thread3 = new ThreadSem(3);
        ThreadSem thread4 = new ThreadSem(4);
    }
}


