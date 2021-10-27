package com.study.board.service;

import com.study.board.domain.Post;
import com.study.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public void create(Post post) {
        postRepository.save(post);
    }

    public List<Post> readAll() {
        return postRepository.findAll();
//        return postRepository.readAll();
    }

    // JpaRepository를 사용하니까 갑자기 리턴타입에 Optional이 붙었음.
    // Optional는 객체를 포장하는 래퍼 클래스임
    // 객체에 Null값이 담겨오면 NullPointerException을 처리해줌.
    public Optional<Post> read(Long seq) {
        return postRepository.findById(seq);
//        return postRepository.read(seq);
    }

    public void update(Long seq, Post newPost) {
        postRepository.save(newPost);
//        return postRepository.update(seq, newPost);
    }

    public void delete(Long seq) {
        postRepository.deleteById(seq);
//        postRepository.delete(seq);
    }

}
