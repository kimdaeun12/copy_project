package com.ll.exam.project.recomment;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommentForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String recomment;
}
