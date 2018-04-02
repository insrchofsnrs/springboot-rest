package by.insrch.sdrw.controller;

import by.insrch.sdrw.pojo.User;
import by.insrch.sdrw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {


    @GetMapping(value="/")
    public String homepage(){
        return "index";
    }
}