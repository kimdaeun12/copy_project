package com.ll.exam.project.comment;

import com.ll.exam.project.borad.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void create(Board board, String content){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreateDate(LocalDateTime.now());
        comment.setBoard(board);
        this.commentRepository.save(comment);
    }

    public Comment getComment(Integer id) {// Integer 로 타입이 들어오면 null 값도 허용해줄 수 있음
        Optional<Comment> answer = this.commentRepository.findById(id);
            return answer.get();

    }
}
