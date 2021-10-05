package com.english_trainer.english_trainer.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AnswerRequest {
    @NotBlank
    private String answer;

    @NotBlank
    private Long question_id;
}
