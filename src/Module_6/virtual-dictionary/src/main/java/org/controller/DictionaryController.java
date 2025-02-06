package org.controller;

import org.model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void addWord(String word, String meaning) {
        dictionary.addWord(word, meaning);
    }

    public String getMeaning(String word) {
        return dictionary.getMeaning(word);
    }

    public String[] getWords() {
        return dictionary.getWords();
    }

    public String searchForWord(String word) {
        return dictionary.searchForWord(word);
    }
}
