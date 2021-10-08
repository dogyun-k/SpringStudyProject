package com.study.board.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.board.domain.User;

import org.springframework.stereotype.Component;

@Component
public class MemoryUserRepository implements UserRepository {

    private Map<Long, User> userDb = new HashMap<>();
    private Long seq = 0L;

    @Override
    public Long save(User user) {
        user.setSeq(seq++);
        userDb.put(user.getSeq(), user);
        return user.getSeq();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userDb.values());
    }

    @Override
    public User findBySeq(Long seq) {
        return userDb.get(seq);
    }
}
