package com.study.board.repository;

import com.study.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    // JpaRepository에 이미 구현되어 있는 것임.
//    Long save(User user);
//    List<User> findAll();
//    User findBySeq(Long seq);


    User findByEmail(String email);
}
