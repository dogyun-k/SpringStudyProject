package com.study.board.controller;

import com.study.board.domain.User;
import com.study.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@RequiredArgsConstructor
@RequestMapping(value = "/user")
@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/new")
    public String registerView() {
        return "user/registerView";
    }

    @PostMapping(value = "/new")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User newUser = User.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        userService.save(newUser);

        return "redirect:/main";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "user/loginView";
    }

    @PostMapping(value = "/login")
    public String loginCheck(Model model, @RequestParam String email, @RequestParam String password) {
        // 세션은 request에 담겨서 온다.

        if (userService.loginCheck(email, password)) {
            User user = userService.findByEmail(email);

            // 로그인 성공 시 세션값을 세팅함.
            // SessionAttributes의 속성 이름과 같은 모델이 추가되면 이를 세션에 저장함.
            model.addAttribute("user", user);
            return "redirect:/posts";
        }

        return "redirect:/user/login";
    }

    @GetMapping(value = "/logout")
    public String logout(SessionStatus sessionStatus) {
        // HttpSession session
        // session.invalidate();

        sessionStatus.setComplete();
        return "redirect:/main";
    }

    @GetMapping(value = "/list")
    public String userList(Model model) {
        model.addAttribute("userList", userService.findAll());

        return "user/listView";
    }

}
