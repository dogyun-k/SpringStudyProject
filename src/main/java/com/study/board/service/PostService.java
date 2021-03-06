package com.study.board.service;

import com.study.board.domain.Post;
import com.study.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor    // final로 정의된 객체를 생성해서 주입함.
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
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public void update(Long id, Post newPost) {
        // 수정은 JPA에서 따로 제공하지 않고 저장 메소드를 호출하면 적절한 UPDATE 쿼리가 전달된다.
        // newPost의 id를 읽어서 스스로 찾아서 수정하나?
        // PK값을 스스로 읽어서?

        Post post = postRepository.findById(id).get().builder()
                .title(newPost.getTitle())
                .content(newPost.getContent())
                .build();

        postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
//        postRepository.delete(id);
    }

}
