package com.study.board.controller;

import java.util.List;

import com.study.board.domain.Post;
import com.study.board.domain.User;
import com.study.board.service.PostService;
import com.study.board.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/post")
@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping(value = "/create")
    public String createView(Model model) {

        model.addAttribute("userList", userService.findAll());
        return "createView";
    }

    @PostMapping(value = "/create")
    public String createPost(@RequestParam Long userSeq, @RequestParam String title, @RequestParam String content) {
        User user = userService.findBySeq(userSeq);
        Post post = new Post(title, content, user);
        postService.create(post);

        return "redirect:/post/board";
    }

    @GetMapping(value = "/board")
    public String readPostList(Model model) {
        List<Post> postList = postService.readAll();
        model.addAttribute("postList", postList);
        return "boardView";
    }

    @GetMapping(value = "{seq}")
    public String postView(@PathVariable Long seq, Model model) {

        return "postView";
    }
}
