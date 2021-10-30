package com.study.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.study.board.domain.Post;
import com.study.board.domain.User;
import com.study.board.repository.MemoryPostRepository;
import com.study.board.repository.PostRepository;

import org.junit.jupiter.api.Test;

public class MemoryPostRepositoryTest {

    private PostRepository postRepository = new MemoryPostRepository();

    @Test
    public void createTest() {

        for (int i = 0; i < 10; i++) {
            User user = new User("id", "pw");
            Post newPost = new Post("title " + i, "content " + i, user.getSeq());
            postRepository.create(newPost);
        }
        List<Post> postList = postRepository.readAll();

        Post firstPost = postList.get(0);
        assertEquals(0, firstPost.getSeq());
        assertEquals(10, postList.size());
    }

    @Test
    public void readByIdTest() {
        for (int i = 0; i < 10; i++) {
            User user = new User("id", "pw");
            Post newPost = new Post("title " + i, "content " + i, user.getSeq());
            postRepository.create(newPost);
        }
        System.out.println(postRepository.read(1L));
    }

}
