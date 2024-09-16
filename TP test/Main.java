import java.util.concurrent.Semaphore;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static List<Semaphore> semaphores = new ArrayList<Semaphore>();
    /*public static Semaphore S2 = new Semaphore (0);
    public static Semaphore S3 = new Semaphore (0);*/
    public static void main(String[] args) {

        for (int i = 0; i<100; i++){
            semaphores.add(new Semaphore(0));
            Ami ami = new Ami(i);
        }
       /* Ami ami1 = new Ami(1);
        Ami ami2 = new Ami(2);
        Ami ami3 = new Ami(3);*/
    }
}