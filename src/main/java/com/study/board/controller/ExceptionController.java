package com.study.board.controller;

import com.study.board.exception.post.PostNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 해당 컨트롤러는 예외를 강제로 발생하기 위해 생성한 것임.

@Controller
public class ExceptionController {

    @RequestMapping("/postError")
    public String postError(){
        throw new PostNotFoundException("해당 게시글이 사라졌습니다.");
    }
}
