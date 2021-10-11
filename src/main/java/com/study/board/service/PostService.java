package com.study.board.service;

import java.util.List;

import com.study.board.domain.Post;
import com.study.board.repository.PostRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Long create(Post post) {
        return postRepository.create(post);
    }

    public List<Post> readAll() {
        return postRepository.readAll();
    }

    public Post read(Long seq) {
        return postRepository.read(seq);
    }

    public Long update(Long seq, Post newPost) {
        return postRepository.update(seq, newPost);
    }

    public void delete(Long seq) {
        postRepository.delete(seq);
    }

}
