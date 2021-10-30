package com.study.board.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Getter
@Entity
public class User {

    @Id
    @Column(name = "user_seq")
    private Long seq;

    private String id;

    private String pw;

    private List<Long> postSeq;

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

}
