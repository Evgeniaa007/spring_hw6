package ru.dorogova.notes.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dorogova.notes.model.Note;
import ru.dorogova.notes.service.IntServiceNote;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

    private final IntServiceNote noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        Note note;
        try{
            note = noteService.getNoteById(id);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }

        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(id, note), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }

}
