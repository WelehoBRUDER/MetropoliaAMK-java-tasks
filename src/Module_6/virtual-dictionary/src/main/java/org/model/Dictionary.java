package org.model;

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
        if (words.containsKey(word)) {
            return getMeaning(word);
        } else {
            return "Word not found";
        }
    }
}