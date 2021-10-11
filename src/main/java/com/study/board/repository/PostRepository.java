package com.study.board.repository;

import java.util.List;

import com.study.board.domain.Post;

public interface PostRepository {
    
    // post 객체 넘겨주면 저장하기
    Long create(Post post);

    // 전체 post 읽기
    List<Post> readAll();

    // seq로 post 1개 읽기
    Post read(Long seq);

    // seq post를 newPost로 바꿔준다.(수정)
    Long update(Long seq, Post newPost);
}
