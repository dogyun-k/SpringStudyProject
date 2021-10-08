package com.study.board.service;

import java.util.List;

import com.study.board.domain.User;
import com.study.board.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long save(User user) {
        userRepository.save(user);
        return user.getSeq();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
