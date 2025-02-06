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

    public static void main(String[] args) {
        DictionaryController controller = new DictionaryController(new Dictionary());
        controller.addWord("hello", "used as a greeting or to begin a conversation");
        controller.addWord("world", "the earth, together with all of its countries and peoples");

        String[] words = controller.getWords();
        for (String word : words) {
            System.out.println(word + ": " + controller.getMeaning(word));
        }
    }
}
