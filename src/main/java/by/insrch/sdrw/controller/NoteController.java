package by.insrch.sdrw.controller;

import by.insrch.sdrw.dao.NoteRepository;
import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.pojo.Note;
import by.insrch.sdrw.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;


    @GetMapping("/notes")
    public ResponseEntity<Note> getNotes(){
        Note note = noteRepository.findOne(1L);

        return new ResponseEntity<>(note,  HttpStatus.OK);
    }
}
