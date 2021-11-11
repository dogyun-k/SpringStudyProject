package com.study.board;

import com.study.board.domain.User;
import com.study.board.repository.UserRepository;
import com.study.board.service.PostService;
import com.study.board.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;


}
