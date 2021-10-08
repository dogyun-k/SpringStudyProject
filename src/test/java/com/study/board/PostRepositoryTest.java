package com.study.board;

import com.study.board.domain.Post;
import com.study.board.domain.User;
import com.study.board.repository.PostRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void createTest() {

        for (int i = 0; i < 10; i++) {
            User user = new User("id", "pw");
            Post newPost = new Post("title " + i, "content " + i, user);
            postRepository.create(newPost);
        }

        System.out.println(postRepository.readAll());
    }

    @Test
    public void readByIdTest() {
        for (int i = 0; i < 10; i++) {
            User user = new User("id", "pw");
            Post newPost = new Post("title " + i, "content " + i, user);
            postRepository.create(newPost);
        }
        System.out.println(postRepository.read(1L));
    }

}
