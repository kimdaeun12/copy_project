package com.ll.exam.project.recomment;

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
public class Recomment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

//    @ManyToOne
//    private Member author;

    @ManyToOne
    private Comment comment;

    private String recomment;

//    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<Recomment> children;
//
//    @ManyToMany
//    private Set<Member> voter;

    @CreatedDate
    private LocalDateTime createDate;

//    private LocalDateTime modifyDate;


}