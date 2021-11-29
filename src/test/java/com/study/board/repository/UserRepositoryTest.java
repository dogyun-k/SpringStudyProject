package com.study.board.repository;

import com.study.board.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {



    @Autowired
    private UserRepository userRepository;

    //    테스트 하는 순서는 보장되지 않는다.
    //
    //    그래서 테스트 하나가 끝나면 해당 테스트에서 사용한 데이터를 클리어해주어야함.
    @AfterEach
    public void afterEach() {
        userRepository.deleteAll();
    }

    @Test
    public void saveTest() {

        User user = new User("testName", "testEmail", "testPassword");

        userRepository.save(user);

        User result = userRepository.findByEmail("testEmail");
        assertThat(user.getEmail()).isEqualTo(result.getEmail());

    }

    @Test
    public void findByEmailTest() {
        User testUser1 = new User("testName1", "testEmail1", "testPassword1");
        User testUser2 = new User("testName2", "testEmail2", "testPassword2");

        userRepository.save(testUser1);
        userRepository.save(testUser2);


        User result = userRepository.findByEmail("testEmail1");

        assertThat(result.getEmail()).isEqualTo(testUser1.getEmail());
    }

    @Test
    public void findAllTest() {

        for (int i = 0; i < 10; i++) {
            User testUser = new User("testName" + i, "testEmail" + i, "testPassword" + i);
            userRepository.save(testUser);
        }

        List<User> userList = userRepository.findAll();

        assertThat(userList.size()).isEqualTo(10);

    }
}
