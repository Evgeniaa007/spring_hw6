package ru.dorogova.notes.service;

import ru.dorogova.notes.model.Note;
import java.util.List;
import java.util.Optional;


public interface IntServiceNote {

    Note createNote(Note note);

    List<Note>getAllNotes();

    Note getNoteById(Long id);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);

}
