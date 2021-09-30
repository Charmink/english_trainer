package com.english_trainer.english_trainer.services;


import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Question findQuestionById(Long id){
        Question question = questionRepository.findQuestionById(id);
        // описать логику проверки корректности получаемого ответа и вернуть
        // результат в контроллер
        return question;
    }

    public Question findQuestionByQuestion(String nameQuestion){
        Question question = questionRepository.findQuestionByQuestion(nameQuestion);
        // аналогично
        return question;
    }
}
