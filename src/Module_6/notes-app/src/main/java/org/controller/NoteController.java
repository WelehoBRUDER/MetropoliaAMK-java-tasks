package org.controller;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.view.NoteView;
import javafx.fxml.FXML;
import org.model.Note;
import org.model.Notebook;

import java.util.ArrayList;

public class NoteController {
    @FXML
    private ListView notesArea;

    @FXML
    private TextArea noteDesc;

    @FXML
    private TextField noteName;

    private Notebook notebook;
    private int currentNoteIndex = -1;

    public NoteController() {
        notebook = new Notebook();
    }

    @FXML
    public void addNote() {
        String title = noteName.getText();
        String content = noteDesc.getText();
        notebook.addNote(new Note(title, content));
        displayAllNotes();
    }

    public HBox createNoteDisplay(Note note) {
        HBox listItem = new HBox();
        listItem.styleProperty().set("-fx-padding: 3px;");
        Label title = new Label(note.getTitle());
        Label content = new Label(note.getContent());
        title.setPrefWidth(120);
        content.setPrefWidth(335);
        title.styleProperty().set("-fx-font-weight: bold;");
        listItem.getChildren().addAll(title, content);
        return listItem;
    }

    @FXML
    public void displayAllNotes() {
        notesArea.getItems().clear();
        for (Note note : notebook.getNotes()) {
            notesArea.getItems().add(createNoteDisplay(note));
        }
    }

    public void removeNote(int index) {
        notebook.removeNote(index);
    }

    public Note getNote(int index) {
        return notebook.getNote(index);
    }

    public int getSize() {
        return notebook.getSize();
    }

    public ArrayList<Note> getNotes() {
        return notebook.getNotes();
    }

    @FXML
    public void deleteNote() {
        if (currentNoteIndex != -1) {
            removeNote(currentNoteIndex);
            displayAllNotes();
        }
    }


}
