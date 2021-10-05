package com.english_trainer.english_trainer.services;

import com.english_trainer.english_trainer.domain.Answer;
import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.exceptions.DataBaseRefactoringException;
import com.english_trainer.english_trainer.exceptions.NullResultException;
import com.english_trainer.english_trainer.payload.AnswerRequest;
import com.english_trainer.english_trainer.repository.AnswerRepository;
import com.english_trainer.english_trainer.repository.QuestionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService implements IAnswerService{
    final QuestionRepository questionRepository;
    final AnswerRepository answerRepository;

    @Override
    public void addAnswer(@NonNull AnswerRequest answerRequest) {
        if (answerRepository.findAnswerByAnswer(answerRequest.getAnswer()).isPresent()) {
            throw new DataBaseRefactoringException("Такой ответ уже существует в БД");
        }
        Answer answer = new Answer();
        Question question = questionRepository.findById(answerRequest.getQuestion_id()).orElseThrow(()->new NullResultException("Вопроса с данным id не существует в БД"));
        answer.setAnswer(answerRequest.getAnswer());
        answer.setQuestion(question);
        answerRepository.save(answer);

    }
}
