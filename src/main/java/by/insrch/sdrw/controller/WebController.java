package by.insrch.sdrw.controller;

import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {
@Autowired
    UserRepository userRepository;


    @GetMapping(value="/")
    public String homepage(Model model){
        List<User> list = userRepository.findAll();
        model.addAttribute("test", list);
        return "index";
    }
}