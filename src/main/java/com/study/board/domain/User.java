package com.study.board.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_seq")
    private Long seq;

    private String id;

    private String pw;

//    @OneToMany
//    private List<Post> posts;

    protected User() {}

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

}
