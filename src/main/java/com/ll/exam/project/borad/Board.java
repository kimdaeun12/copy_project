package com.ll.exam.project.borad;


import com.ll.exam.project.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title; // 제목

    private String content; // 내용

//    @ManyToOne
//    private Member author; //글쓴이

//    @ManyToOne
//    private Category category; //분휴 카테고리
//
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Comment> commentList; //댓글

//    @ManyToMany
//    private Set<Member> voter; //추천

    @CreatedDate
    private LocalDateTime createDate; // 생성일

    private LocalDateTime modifyDate; // 수정일
}