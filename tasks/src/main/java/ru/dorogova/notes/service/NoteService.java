package ru.dorogova.notes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dorogova.notes.model.Note;
import ru.dorogova.notes.repository.NoteRepository;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class NoteService implements IntServiceNote {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow();
    }

    @Override
    public Note updateNote(Long id, Note note) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note1 = optionalNote.get();
            note1.setTitle(note.getTitle());
            note1.setContent(note.getContent());
            return noteRepository.save(note1);
        } else {
            throw new IllegalArgumentException("Couldn't found note with id: " + id);
        }
    }

    @Override
    public void deleteNote(Long id) {
        Note note = getNoteById(id);
        noteRepository.delete(note);
    }
}

