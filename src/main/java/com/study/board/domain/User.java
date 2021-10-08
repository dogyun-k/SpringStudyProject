package com.study.board.domain;

import lombok.Data;

@Data
public class User {

    private Long seq;
    private String id;
    private String pw;

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

}
