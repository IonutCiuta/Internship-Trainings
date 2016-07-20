package primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by iciuta on 7/20/2016.
 */
public class PrimeMain {
    private static final int INPUT_SIZE = 100 * 1000;

   /**
    * System has 2 cores + hyperthreading => 4 threads
    * 1 thread > 1000 ms
    * 2 threads ~800 ms
    * 4 threads ~500 ms
    * */
    private static final int THREADS = 4;

    private static List<Integer> input = createInput();
    private static List<Integer> result = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        int chunk = input.size()/THREADS;

        for(int i = 0; i < THREADS; i++) {
            threads.add(new Thread(new Searcher(i, i*chunk, (i + 1)*chunk)));
        }

        long start = System.currentTimeMillis();
        for(Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println(result);
        System.out.println(THREADS + " threads " + INPUT_SIZE + " input size -> " + (end - start));
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> createInput() {
        List<Integer> result = new ArrayList<>();

        for(int i = 1; i <= INPUT_SIZE; i++) {
            result.add(i);
        }

        return result;
    }

    private static class Searcher implements Runnable {
        private int id, start, end;

        public Searcher(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            System.out.println("Searcher " + id +" - started");
            for(int i = start; i < end; i++) {
                if(isPrime(input.get(i))) {
                    result.add(input.get(i));
                }
            }
            System.out.println("Searcher " + id +" - ended");
        }
    }
}
