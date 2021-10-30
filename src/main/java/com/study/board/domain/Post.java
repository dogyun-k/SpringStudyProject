package com.study.board.domain;

import lombok.Data;

@Data
public class Post {

    private Long seq;

    private String title;

    private String content;

    // 중복데이터 발생할 수 있음.
    // Post만 봐도 유저 정보를 다 알 수 있게 됨.
    // userSeq를 받게 하자.
    // private User user;

    private Long userSeq;

    private String userId;

    public Post(String title, String content, Long userSeq, String userId) {
        this.title = title;
        this.content = content;
        this.userSeq = userSeq;
        this.userId = userId;
    }

}
