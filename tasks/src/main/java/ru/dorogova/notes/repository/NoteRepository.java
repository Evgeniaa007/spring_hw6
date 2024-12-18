package ru.dorogova.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dorogova.notes.model.Note;
import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
