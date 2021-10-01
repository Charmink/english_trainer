package com.english_trainer.english_trainer.services;

import com.english_trainer.english_trainer.domain.Question;
import lombok.NonNull;

public interface IQuestionService {
    @NonNull
    Question findQuestionById(@NonNull Long id);
}
