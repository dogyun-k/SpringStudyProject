package com.study.board.exception.post;

public class PostException extends RuntimeException {

    // 직렬화를 할 때 serialVersionUID를 사용한다.
    // 해당 값을 지정하지 않으면 컴파일러가 지정을 하는데..
    // 컴파일러의 변경에 따라 해당 값이 바뀔 수 있다.
    // 객체를 저장하고 불러올 때 해당 값에 근거하여 불러오는데.
    // 이 값이 바뀐다면 문제가 생긴다.
    // 예를 들어 저장할 때의 컴파일러와 불러올 때의 컴파일러가 다를 경우.
    private static final long serialVersionUID = 1L;

    public PostException(String message) {
        super(message);
    }

}
