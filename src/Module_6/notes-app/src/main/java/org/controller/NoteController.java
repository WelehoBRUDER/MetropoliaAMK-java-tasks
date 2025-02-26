package org.controller;

import javafx.scene.control.*;
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
    @FXML
    private Button deleteNoteButton;

    private Notebook notebook;
    private int currentNoteIndex = -1;

    public NoteController() {
        notebook = new Notebook();
    }

    @FXML
    public void addNote() {
        if (currentNoteIndex != -1) {
            Note currentNote = getNote(currentNoteIndex);
            currentNote.setTitle(noteName.getText());
            currentNote.setContent(noteDesc.getText());
            displayAllNotes();
            currentNoteIndex = -1;
            deleteNoteButton.setDisable(true);
        } else {
            String title = noteName.getText();
            String content = noteDesc.getText();
            notebook.addNote(new Note(title, content));
            displayAllNotes();
        }
    }

    public HBox createNoteDisplay(Note note, int index) {
        HBox listItem = new HBox();
        listItem.styleProperty().set("-fx-padding: 3px;");
        Label title = new Label(note.getTitle());
        Label content = new Label(note.getContent());
        title.setPrefWidth(120);
        content.setPrefWidth(300);
        title.styleProperty().set("-fx-font-weight: bold;");
        listItem.getStyleClass().add("list-item");
        listItem.getChildren().addAll(title, content);
        listItem.setFocusTraversable(false);
        listItem.setId("note" + index);

        listItem.setOnMousePressed(e -> {
            e.consume();
            switchSelectionVisual(index);
            currentNoteIndex = index;
            Note currentNote = getNote(currentNoteIndex);
            noteName.setText(currentNote.getTitle());
            noteDesc.setText(currentNote.getContent());
            deleteNoteButton.setDisable(false);
        });
        return listItem;
    }

    @FXML
    public void switchSelectionVisual(int index) {
        if (currentNoteIndex != -1) {
            HBox prevNote = (HBox) notesArea.lookup("#note" + currentNoteIndex);
            prevNote.getStyleClass().remove("selected");
        }
        HBox currentNote = (HBox) notesArea.lookup("#note" + index);
        currentNote.getStyleClass().add("selected");
    }

    @FXML
    public void displayAllNotes() {
        notesArea.getItems().clear();
        for (int i = 0; i < notebook.getSize(); i++) {
            HBox noteDisplay = createNoteDisplay(notebook.getNote(i), i);
            notesArea.getItems().add(noteDisplay);
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
            currentNoteIndex = -1;
            deleteNoteButton.setDisable(true);
        }
    }


}
