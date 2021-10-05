package com.english_trainer.english_trainer.services;

import com.english_trainer.english_trainer.payload.AnswerRequest;
import lombok.NonNull;

public interface IAnswerService {
    void addAnswer(@NonNull AnswerRequest answerRequest);
}
