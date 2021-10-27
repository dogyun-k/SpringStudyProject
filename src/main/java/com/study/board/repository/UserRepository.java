package com.study.board.repository;

import java.util.List;

import com.study.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // JpaRepository에 이미 구현되어 있는 것임.
//    Long save(User user);
//    List<User> findAll();
//    User findBySeq(Long seq);
}
