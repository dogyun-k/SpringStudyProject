package com.study.board.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;

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
