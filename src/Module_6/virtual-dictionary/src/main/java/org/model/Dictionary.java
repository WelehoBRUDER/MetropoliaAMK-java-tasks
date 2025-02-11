package org.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words = new HashMap<>();

    public void addWord(String word, String meaning) {
        words.put(word, meaning);
    }

    public String getMeaning(String word) {
        return words.get(word);
    }

    public String[] getWords() {
        return words.keySet().toArray(new String[0]);
    }

    // Placeholder, will be replaced by actual search logic
    public String searchForWord(String word) {
        String[] words = getWords();
        ArrayList<String> matching = new ArrayList<>();
        for (String w : words) {
            if (w.toLowerCase().contains(word.toLowerCase())) {
                matching.add(w);
            }
        }
        return "Word not found";
    }
}