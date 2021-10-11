package com.study.board.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.board.domain.Post;

import org.springframework.stereotype.Component;

@Component
public class MemoryPostRepository implements PostRepository {

    private Map<Long, Post> postDb = new HashMap<>();
    private Long seq = 0L;

    @Override
    public Long create(Post post) {
        post.setSeq(seq++);
        postDb.put(post.getSeq(), post);
        return seq;
    }

    @Override
    public List<Post> readAll() {
        return new ArrayList<>(postDb.values());
    }

    @Override
    public Post read(Long seq) {
        return postDb.get(seq);
    }

    @Override
    public Long update(Long seq, Post post) {
        // 중복된 key(seq)가 있으면 알아서 value를 바꿔준다.
        post.setSeq(seq);
        postDb.put(seq, post);
        return seq;
    }

    @Override
    public void delete(Long seq) {
        postDb.remove(seq);
    }

}
