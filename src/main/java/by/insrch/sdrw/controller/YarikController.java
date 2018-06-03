package by.insrch.sdrw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YarikController {


    @GetMapping(value="/yarik")
    public String yarikPage(){
        return "yarik";
    }

}
