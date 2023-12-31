package com.ll.exam.project.recomment;

import com.ll.exam.project.borad.BoardService;
import com.ll.exam.project.comment.Comment;
import com.ll.exam.project.comment.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/recomment")
@RequiredArgsConstructor
@Controller
public class RecommentController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final RecommentService recommentService;

    @PostMapping("/create/{id}")
    public String createRecomment(Model model, @PathVariable("id") Integer id, @Valid RecommentForm recommentForm, BindingResult bindingResult, Principal principal){

        Comment comment = this.commentService.getComment(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("comment", comment);
            return "board_detail";
        }
        this.commentService.create(comment.getBoard(), recommentForm.getRecomment());
        return String.format("redirect:/board/detail/%s#comment_%s",
                comment.getBoard().getId(), comment.getId());
    }
}
