package com.english_trainer.english_trainer.services;


import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.exceptions.NullResultException;
import com.english_trainer.english_trainer.repository.QuestionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{
    private final QuestionRepository questionRepository;

    @Override
    public @NonNull Question findQuestionById(@NonNull Long id){
        return questionRepository.findQuestionById(id).orElseThrow(() -> new NullResultException("Ничего не найдено по заданному id"));
    }

    public Question findQuestionByQuestion(String nameQuestion){
        Question question = questionRepository.findQuestionByQuestion(nameQuestion);
        // аналогично
        return question;
    }
}
