package com.english_trainer.english_trainer.payload;

import com.english_trainer.english_trainer.domain.Answer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class QuestionResponse {
    @NotBlank
    private String question;

    @NotBlank
    private String answer;

    @NotBlank
    private Long branch_id;

    @NotBlank
    private Set<AnswerResponse> answers = new HashSet<>();
}
