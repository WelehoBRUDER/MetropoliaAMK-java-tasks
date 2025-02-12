package org.model;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList();

    public void populateWords() {
        // Create new JSON parser
        JSONParser parser = new JSONParser();
        try {
            // Fetch the words from the JSON file
            JSONArray wordsArray = (JSONArray) parser.parse(new FileReader("src/main/resources/words.json"));
            for (Object obj : wordsArray) {
                // Get the word object
                JSONObject word = (JSONObject) obj;

                // Extract the title, definition, and examples
                String title = (String) word.get("title");
                String definition = (String) word.get("definition");
                JSONArray examples = (JSONArray) word.get("examples");

                // Parse the examples into a string array
                String[] examplesArray = new String[examples.size()];
                for (int i = 0; i < examples.size(); i++) {
                    examplesArray[i] = (String) examples.get(i);
                }
                addWord(title, definition, examplesArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addWord(String word, String definition, String[] examples) {
        words.add(new Word(word, definition, examples));
    }

    public String getMeaning(String word) {
        for (Word w : words) {
            if (w.getId().equals(word.toLowerCase())) {
                return w.getDefinition();
            }
        }
        return "Word not found";
    }

    public ArrayList<Word> getWordObjects() {
        return words;
    }

    public ArrayList<String> getWords() {
        // Return all titles of words
        ArrayList<String> words = new ArrayList<>();
        for (Word w : this.words) {
            words.add(w.getTitle());
        }
        return words;
    }

    // Searches for all words that include the query somewhere, not case-sensitive.
    // All matching words are then sorted in order of most matching to least matching.
    public ArrayList<Word> searchForWord(String word) {
        ArrayList<Word> words = getWordObjects();
        ArrayList<Word> matching = new ArrayList<>();
        // Filter to only matching words
        for (Word w : words) {
            if (w.getId().contains(word.toLowerCase())) {
                matching.add(w);
            }
        }
        // Sort by indexOf(query)
        matching.sort((a, b) -> a.compareTo(b, word));
        return matching;
    }
}