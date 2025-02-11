package org.controller;

import org.model.Dictionary;

import java.util.ArrayList;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.dictionary.populateWords();
    }

    public void addWord(String title, String definition, String[] examples) {
        dictionary.addWord(title, definition, examples);
    }

    public String getMeaning(String word) {
        return dictionary.getMeaning(word);
    }

    public ArrayList<String> getWords() {
        return dictionary.getWords();
    }

    public String searchForWord(String word) {
        return dictionary.searchForWord(word);
    }
}
