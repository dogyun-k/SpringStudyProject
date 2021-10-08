package com.study.board.domain;

import lombok.Data;

@Data
public class Post {

    private Long seq;

    private String title;

    private String content;

    private User user;

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

}
