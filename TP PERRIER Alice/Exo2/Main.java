package Exo2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int MIN_PRIORITY = 1;
    public static int MAX_PRIORITY = 10; 
    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = MIN_PRIORITY; i<MAX_PRIORITY+1; i++){
            ThreadPrio thread = new ThreadPrio(i);
            threads.add(thread);
        }

        
    

    }
}