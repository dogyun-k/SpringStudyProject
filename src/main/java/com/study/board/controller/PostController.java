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
@RequestMapping(value = "/posts")
@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;

    // URL 수정함. 동사를 없애고 REST의 장점을 최대한 살리기 위함.
    @GetMapping
    public String readPostList(Model model) {
        List<Post> postList = postService.readAll();
        model.addAttribute("postList", postList);

        return "postsView";
    }

    // 요청 파라미터가 들어와야함.
    // 안 들어오면 예외발생
    @GetMapping(value = "/postinfo")
    public String postView(@RequestParam Long seq, Model model) {
        model.addAttribute("post", postService.read(seq));
        return "postView";
    }

    @GetMapping(value = "/post")
    public String createView(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "createView";
    }

    @PostMapping(value = "/post")
    public String createPost(@RequestParam Long userSeq, @RequestParam String title, @RequestParam String content) {
        User user = userService.findBySeq(userSeq);
        Post post = new Post(title, content, user);
        postService.create(post);

        return "redirect:/posts";
    }

    @GetMapping(value = "/repost")
    public String updateView(@RequestParam Long seq, Model model) {
        model.addAttribute("post", postService.read(seq));
        return "updateView";
    }

    @PostMapping(value = "/repost")
    public String updatePost(@RequestParam Long seq, @RequestParam String title, @RequestParam String content,
            @RequestParam Long userSeq) {
        Post newPost = new Post(title, content, userService.findBySeq(userSeq));
        postService.update(seq, newPost);

        return "redirect:/posts";
    }

    @GetMapping(value = "/depost")
    public String deletePost(@RequestParam Long seq) {
        postService.delete(seq);
        return "redirect:/posts";
    }
}
