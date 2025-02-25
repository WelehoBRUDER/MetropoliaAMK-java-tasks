package org.model;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook() {
        notes = new ArrayList<Note>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(int index) {
        notes.remove(index);
    }

    public Note getNote(int index) {
        return notes.get(index);
    }

    public int getSize() {
        return notes.size();
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }
}
