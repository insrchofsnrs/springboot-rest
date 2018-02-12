package by.insrch.sdrw.controller;

import by.insrch.sdrw.dao.NoteRepository;
import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.pojo.User;
import by.insrch.sdrw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class TestControllerRest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getLists(){

        userService.addusers();

        List listA = userRepository.findAll();
        List listB = noteRepository.findAll();
        List result = new ArrayList();
        result.add(listA);
        result.add(listB);
        return new ResponseEntity<>(result,  HttpStatus.OK);

    }



    /*@GetMapping("/")
    public List<User> users(){
        userService.addusers();
        return userRepository.findAll();
    }*/

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }


    @GetMapping("/second")
    public String sayHi2(){
        return "второе сообщение ебать)";
    }
}
