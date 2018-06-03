package by.insrch.sdrw.controller;
import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestCintroller {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/test")
    public List<User> getTestList(Model model) {
        model.addAttribute("testText", "hello");
        List<User> list = userRepository.findAll();
        return list;
    }


}
