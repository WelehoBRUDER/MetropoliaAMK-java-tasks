package org.model;

public class Word implements Comparable {
    private final String title;
    private final String definition;
    private final String[] examples;

    public Word(String title, String definition, String[] examples) {
        this.title = title;
        this.definition = definition;
        this.examples = examples;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return title.toLowerCase();
    }

    public String getDefinition() {
        return definition;
    }

    public String[] getExamples() {
        return examples;
    }

    public int compareTo(Object o, String search) {
        String a = this.getId();
        String b = ((Word) o).getId();
        return Integer.compare(a.indexOf(search), b.indexOf(search));
    }

    @Override
    public int compareTo(Object o) {
        String a = this.getId();
        String b = ((Word) o).getId();
        return a.compareTo(b);
    }
}
