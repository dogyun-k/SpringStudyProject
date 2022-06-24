package com.study.board.controller;

import com.mysql.cj.Session;
import com.study.board.domain.Post;
import com.study.board.domain.User;
import com.study.board.exception.post.PostNotFoundException;
import com.study.board.service.PostService;
import com.study.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@SessionAttributes("user")
@RequiredArgsConstructor
@RequestMapping(value = "/posts")
@Controller
public class PostController {

    private final PostService postService;

    @ModelAttribute("user")
    public User setUser(){
        return new User();
    }

    // URL 수정함. 동사를 없애고 REST의 장점을 최대한 살리기 위함.
    @GetMapping
    public String readPostList(@ModelAttribute("user") User user, Model model) {
        if (user.getId() == null){
            return "redirect:/user/login";
        }

        List<Post> posts = postService.readAll();
        model.addAttribute("posts", posts);

        return "post/postsView";
    }

    // 요청 파라미터가 들어와야함.
    // 안 들어오면 예외발생
    @GetMapping(value = "/postinfo")    // 단일 글 읽어오기
    public String postView(@ModelAttribute("user") User user, @RequestParam Long id, Model model) {
        if (user.getId() == null){
            return "redirect:/user/login";
        }

        Optional<Post> post = postService.findById(id);
        if(post.isEmpty()){
            throw new PostNotFoundException("해당 게시글을 찾을 수 없습니다.");
        }

        model.addAttribute("post", post.get());
        return "post/postView";
    }

    @GetMapping(value = "/post")
    public String createView(@ModelAttribute("user") User user, Model model) {
        if (user.getId() == null){
            return "redirect:/user/login";
        }

        return "post/createView";
    }

    @PostMapping(value = "/post")
    public String createPost(@ModelAttribute("user") User user, @RequestParam String title, @RequestParam String content) {
        if (user.getId() == null){
            return "redirect:/user/login";
        }
        // 세션에 저장된 유저 정보는 Object로 받으며 이를 User 객체로 형변환을 해줌.
        // 원래 request session을 받아와서 했지만 수정함.
        // User user = (User) session.getAttribute("CertifiedUser");

        // Optional<User> user = userService.findById(userId); // 이 부분을 Optional로 받아 오면 Null확인을 해야하는데 예외처리를 어떻게 해야 할까
        Post post = Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();

        postService.create(post);

        return "redirect:/posts";
    }

    @GetMapping(value = "/repost")
    public String updateView(@ModelAttribute("user") User user, @RequestParam Long postId, Model model) {
        if (user.getId() == null){
            return "redirect:/user/login";
        }

        Optional<Post> post = postService.findById(postId);
        post.ifPresent(value -> model.addAttribute("post", value));

        return "post/updateView";
    }

    @PostMapping(value = "/repost")
    public String updatePost(@ModelAttribute("user") User user, @RequestParam Long postId, @RequestParam String title, @RequestParam String content,
                             @RequestParam Long userId) {
        if (user.getId() == null){
            return "redirect:/user/login";
        }

        Post modifiedPost = Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
        postService.update(postId, modifiedPost);

        return "redirect:/posts";
    }

    // DeleteMapping 하려면 ajax를 써야하는가.
    // 이거를 못 해서 URI가 통일되지 못 함..
    @GetMapping(value = "/depost")
    public String deletePost(@ModelAttribute("user") User user, @RequestParam Long postId) {
        if (user.getId() == null){
            return "redirect:/user/login";
        }
        postService.delete(postId);

        return "redirect:/posts";
    }
}
