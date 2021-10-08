package com.study.board.controller;

import com.study.board.domain.User;
import com.study.board.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public String registerView() {
        return "registerView";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam String id, @RequestParam String pw) {
        User newUser = new User(id, pw);
        userService.save(newUser);

        System.out.println(newUser.toString());
        return "redirect:/";
    }

    @GetMapping(value = "/list")
    public String userList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "userListView";
    }

}
