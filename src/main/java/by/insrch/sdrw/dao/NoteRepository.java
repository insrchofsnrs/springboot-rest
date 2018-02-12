package by.insrch.sdrw.dao;

import by.insrch.sdrw.pojo.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
