package com.study.board.repository;

import com.study.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

//    // post 객체 넘겨주면 저장하기
//    Long create(Post post);
//
//    // 전체 post 읽기
//    List<Post> readAll();
//
//    // seq로 post 1개 읽기
//    Post read(Long seq);
//
//    // seq post를 newPost로 바꿔준다.(수정)
//    Long update(Long seq, Post newPost);
//
//    // post seq로 삭제하기
//    void delete(Long seq);

    // 이전에 구현했던 것들은 JpaRepository에 이미 구현되어 있는 것이다. (간단한 것들이라서)
    // 앞으로 더 복잡한 쿼리문을 쓰기 위해서. 더 효율적인 쿼리문을 작성하려면 커스텀으로 만들 수 있다.
}
