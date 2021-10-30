package com.study.board.controller;

import java.util.List;
import java.util.Optional;

import com.study.board.domain.Post;
import com.study.board.domain.User;
import com.study.board.service.PostService;
import com.study.board.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping(value = "/postinfo")    // 단일 글 읽어오기
    public String postView(@RequestParam Long seq, Model model) {
        Optional<Post> post = postService.findById(seq);
        model.addAttribute("post", post.get());
        return "postView";
    }

    @GetMapping(value = "/post")
    public String createView(Model model) {
        model.addAttribute("userList", userService.findAll());

        return "createView";
    }

    @PostMapping(value = "/post")
    public String createPost(@RequestParam Long userSeq, @RequestParam String title, @RequestParam String content) {
        Optional<User> user = userService.findBySeq(userSeq);
        Post post = new Post(title, content, user.get());      // 이 부분을 Optional로 받아 오면 Null확인을 해야하는데 예외처리를 어떻게 해야 할까
        postService.create(post);

        return "redirect:/posts";
    }

    @GetMapping(value = "/repost")
    public String updateView(@RequestParam Long postSeq, Model model) {
        Optional<Post> post = postService.findById(postSeq);
        model.addAttribute("post", post.get());

        return "updateView";
    }

    @PostMapping(value = "/repost")
    public String updatePost(@RequestParam Long seq, @RequestParam String title, @RequestParam String content,
                             @RequestParam Long userSeq) {
        Optional<User> user = userService.findBySeq(userSeq);
        Post modifiedPost = new Post(title, content, user.get());
        postService.update(seq, modifiedPost);

        return "redirect:/posts";
    }

    // DeleteMapping 하려면 ajax를 써야하는가.
    // 이거를 못 해서 URI가 통일되지 못 함..
    @GetMapping(value = "/depost")
    public String deletePost(@RequestParam Long postSeq) {
        postService.delete(postSeq);

        return "redirect:/posts";
    }
}
