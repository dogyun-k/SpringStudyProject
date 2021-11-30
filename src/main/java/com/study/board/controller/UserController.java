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

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/new")
    public String registerView() {
        return "user/registerView";
    }

    @PostMapping(value = "/new")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User newUser = new User(name, email, password);
        userService.save(newUser);

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "user/loginView";
    }

    @PostMapping(value = "/login")
    public String loginCheck(HttpSession httpSession, @RequestParam String email, @RequestParam String password) {
        // 세션은 requset에 담겨서 온다.
        // TODO session 처리

        if (userService.loginCheck(email, password)) {
            User user = userService.findByEmail(email);

            // 로그인 성공 시 세션값을 세팅함.
            httpSession.setAttribute("USER", user);
            return "redirect:/posts";
        }

        return "redirect:/user/login";
    }

    @PostMapping(value = "/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping(value = "/list")
    public String userList(Model model) {
        model.addAttribute("userList", userService.findAll());

        return "user/listView";
    }

}
