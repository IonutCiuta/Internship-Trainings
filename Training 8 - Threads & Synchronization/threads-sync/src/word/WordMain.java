package word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by iciuta on 7/20/2016.
 */
public class WordMain {
    private static final String FILE = "input";

    /**
     * 1 thread ~ 90 ms
     * 2 threads ~ 45 ms
     * 4 threads ~ varies a lot (30, 100)
     * */
    private static final int THREADS = 4;
    private static final String SEPARATORS = "\\W";

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        List<String> textChunks = splitInput(getFileAsString(FILE));
        List<Worker> workers = new ArrayList<>();
        int wordCount = 0;

        for(int i = 0; i < THREADS; i++) {
            workers.add(new Worker(i, dictionary.getContent(), textChunks.get(i)));
        }

        long start = System.currentTimeMillis();
        for(Worker worker : workers) {
            worker.start();
        }

        for(Worker worker : workers) {
            try {
                worker.join();
                wordCount += worker.getWordCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(THREADS + " threads " + wordCount + " words -> " + (end - start));
        System.out.println();

        dictionary.setWordCount(wordCount);
        dictionary.displaySorted();
    }

    private static String getFileAsString(String filename) {
        String content = null;
        try {
            /* Source: stackoverflow */
            content = new Scanner(new File(filename)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

    private static List<String> splitInput(String input) {
        List<String> chunks = new ArrayList<>();
        int chunkSize = input.length()/THREADS;

        for(int i = 0; i < THREADS; i++) {
            if(i != (THREADS - 1)) {
                chunks.add(input.substring(i * chunkSize, (i + 1) * chunkSize));
            } else {
                chunks.add(input.substring(i * chunkSize));
            }
        }

        return chunks;
    }

    private static class Worker extends Thread {
        private ConcurrentHashMap<String, Integer> dictionary;
        private String input;
        private Integer wordCounter;
        private int id;

        public Worker(int id, ConcurrentHashMap<String, Integer> dictionary, String input) {
            this.id = id;
            this.dictionary = dictionary;
            this.input = input;
            this.wordCounter = 0;
        }

        @Override
        public void run() {
            System.out.println("Worker " + id + " - started");

            String[] words = input.split(SEPARATORS);
            for(String word : words) {
                wordCounter++;
                if(dictionary.containsKey(word)) {
                    dictionary.put(word, dictionary.get(word) + 1);
                } else {
                    dictionary.put(word, 1);
                }
            }

            System.out.println("Worker " + id + " - ended");
        }

        public int getWordCount() { return wordCounter; }
    }
}
