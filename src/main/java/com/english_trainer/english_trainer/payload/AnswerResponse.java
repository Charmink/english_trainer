package com.english_trainer.english_trainer.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AnswerResponse {
    public AnswerResponse(String answer, Long question_id){
        this.answer = answer;
        this.question_id = question_id;
    }
    @NotBlank
    private String answer;

    @NotBlank
    private Long question_id;
}

