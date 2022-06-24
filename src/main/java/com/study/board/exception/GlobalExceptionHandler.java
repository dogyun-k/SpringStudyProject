package com.study.board.exception;

import com.study.board.exception.post.PostException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   // 해당 어노테이션으로 모든 컨트롤러에서 발생하는 예외는 여기서 처리된다.
public class GlobalExceptionHandler {

    @ExceptionHandler(PostException.class)      // PostException 예외 클래스에 대한 처리
    public String handleCustomException(PostException exception, Model model) {
        model.addAttribute("exception", exception);
        return "errors/postError";
    }

    @ExceptionHandler(Exception.class)          // Exception 클래스에 대한 처리
    public String handleException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "errors/globalError";
    }
}
