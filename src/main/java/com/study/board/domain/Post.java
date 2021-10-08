package com.study.board.domain;

import lombok.Data;

@Data
public class Post {

    private Long seq;

    private String title;

    private String content;

    private String author;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
