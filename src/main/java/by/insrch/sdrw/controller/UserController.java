package by.insrch.sdrw.controller;

import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.exception.EmailExistsException;
import by.insrch.sdrw.pojo.User;
import by.insrch.sdrw.service.IUserService;
import by.insrch.sdrw.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService iUserService;




    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userRepository.findAll();
        System.out.println(users.isEmpty());
        if (users.isEmpty()){return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user = userRepository.findOne(id);
        if (user==null){ return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser (@RequestBody User user){
        try {
            iUserService.registerNewUserAccount(user);
            //System.out.println(newUser);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (EmailExistsException e) {
            e.printStackTrace();
        } return new ResponseEntity<>(user, HttpStatus.CONFLICT);


    }

}
