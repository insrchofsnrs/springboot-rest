package by.insrch.sdrw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class AdminController {


    @GetMapping(value = "/admin")
    public String adminPage (){
        return "admin";
    }


    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
