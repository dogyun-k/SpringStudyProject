package com.study.board.exception.user;

public class UserNotFoundError extends UserException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundError(String message) {
        super(message);
    }
}
