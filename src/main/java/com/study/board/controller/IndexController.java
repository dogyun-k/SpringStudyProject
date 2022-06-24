package com.study.board.controller;

import com.study.board.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("user")
@Controller
public class IndexController {

    @ModelAttribute("user")
    public User setUser(){
        return new User();
    }

    @GetMapping(value = "/main")
    public String mainView(){
        return "main";
    }

}
