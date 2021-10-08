package com.study.board.repository;

import java.util.List;

import com.study.board.domain.User;

public interface UserRepository {
    
    Long save(User user);
    List<User> findAll();
}
