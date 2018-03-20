package by.insrch.sdrw.controller;

import by.insrch.sdrw.dao.NoteRepository;
import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.pojo.Note;
import by.insrch.sdrw.pojo.User;
import by.insrch.sdrw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class TestControllerRest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;


    @GetMapping("/note")
    public ResponseEntity<Note> getLists(){
        Note note = noteRepository.findOne(1L);

        return new ResponseEntity<>(note,  HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(){
        User user = userRepository.findOne(2l);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }

    /*@GetMapping("/")
    public List<User> users(){
        userService.addusers();
        return userRepository.findAll();
    }*/




    @GetMapping("/second")
    public String sayHi2(){
        return "второе сообщение ебать)";
    }
}
