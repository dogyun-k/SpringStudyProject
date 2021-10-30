package com.study.board;

import java.util.List;

import com.study.board.domain.Post;
import com.study.board.domain.User;
import com.study.board.service.PostService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void createTest() {

        for (int i = 0; i < 10; i++) {
            User user = new User("id", "pw");
            Post newPost = new Post("title " + i, "content " + i, user);
            postService.create(newPost);
        }

        List<Post> postList = postService.readAll();

        for (Post post : postList) {
            System.out.println(post);
        }
    }
}
