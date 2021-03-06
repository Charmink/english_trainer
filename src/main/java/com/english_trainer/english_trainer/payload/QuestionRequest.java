package com.english_trainer.english_trainer.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QuestionRequest {
    @NotBlank
    private String question;

    @NotBlank
    private String answer;

}
