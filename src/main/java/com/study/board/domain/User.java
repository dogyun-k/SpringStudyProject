package com.study.board.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class User {

    @Id
    private Long seq;

    private String id;

    private String pw;

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

}
