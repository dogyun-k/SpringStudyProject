package com.study.board.exception.post;

public class PostNotFoundException extends PostException {

    private static final long serialVersionUID = 1L;

    public PostNotFoundException(String message) {
        super(message);
    }
}
