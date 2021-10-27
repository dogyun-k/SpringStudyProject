package com.study.board.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private Long userSeq;

    public Post(String title, String content, Long userSeq) {
        this.title = title;
        this.content = content;
        this.userSeq = userSeq;
    }

}
