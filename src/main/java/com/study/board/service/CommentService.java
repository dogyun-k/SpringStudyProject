package com.study.board.service;

import com.study.board.domain.Comment;
import com.study.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public Long createComment(Comment comment) {
        commentRepository.save(comment);
        return comment.getId();
    }

}
