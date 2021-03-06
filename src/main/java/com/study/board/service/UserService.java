package com.study.board.service;

import com.study.board.domain.User;
import com.study.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public boolean loginCheck(String email, String password) {
        User user = userRepository.findByEmail(email);

        return passwordEncoder.matches(password, user.getPassword());
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
