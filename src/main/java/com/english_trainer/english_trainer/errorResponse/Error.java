package com.english_trainer.english_trainer.errorResponse;

import lombok.Data;

@Data
public class Error {
    private final String code;
    private final String message;
}