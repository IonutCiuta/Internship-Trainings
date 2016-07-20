package word;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by iciuta on 7/20/2016.
 */
public class Dictionary {
    private Integer wordCount;
    private ConcurrentHashMap<String, Integer> content;

    public Dictionary() {
        this.wordCount = 0;
        this.content = new ConcurrentHashMap<>();
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public ConcurrentHashMap<String, Integer> getContent() {
        return content;
    }

    public void setContent(ConcurrentHashMap<String, Integer> content) {
        this.content = content;
    }

    public void display() {
        for (String word : content.keySet()) {
            double percent = (double) content.get(word) * 100 / wordCount;
            System.out.println(word + " -> " + String.format("%.2f", percent) + "%");
        }

        System.out.println("TOTAL: " + wordCount);
    }

    public void displaySorted() {
        List<WordEntry> words = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : content.entrySet()) {
            double percent = (double) entry.getValue() * 100 / wordCount;
            words.add(new WordEntry(entry.getKey(), percent));
        }

        Collections.sort(words, new Comparator<WordEntry>() {
            @Override
            public int compare(WordEntry o1, WordEntry o2) {
                if(o1.percent.equals(o2.percent)) {
                    return -o1.word.compareTo(o2.word);
                } else {
                    return -o1.percent.compareTo(o2.percent);
                }
            }
        });

        for(WordEntry wordEntry : words) {
            System.out.println(wordEntry.toString());
        }
    }

    private class WordEntry {
        String word;
        Double percent;

        public WordEntry(String word, Double percent) {
            this.word = word;
            this.percent = percent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof WordEntry)) return false;

            WordEntry wordEntry = (WordEntry) o;

            if (!word.equals(wordEntry.word)) return false;
            return percent.equals(wordEntry.percent);

        }

        @Override
        public int hashCode() {
            int result = word.hashCode();
            result = 31 * result + percent.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return word + " -> " + String.format("%.2f", percent) + "%";
        }
    }
}
