package com.english_trainer.english_trainer.services;


import com.english_trainer.english_trainer.domain.Answer;
import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.exceptions.DataBaseRefactoringException;
import com.english_trainer.english_trainer.exceptions.NullResultException;
import com.english_trainer.english_trainer.payload.AnswerResponse;
import com.english_trainer.english_trainer.payload.QuestionRequest;
import com.english_trainer.english_trainer.payload.QuestionResponse;
import com.english_trainer.english_trainer.repository.AnswerRepository;
import com.english_trainer.english_trainer.repository.BranchRepository;
import com.english_trainer.english_trainer.repository.QuestionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{

    private final QuestionRepository questionRepository;
    private final BranchRepository branchRepository;
    private final AnswerRepository answerRepository;

    @Override
    public @NonNull QuestionResponse getQuestion(@NonNull Long id, @NonNull String branchTitle){
        Question question = questionRepository.findById(id).orElseThrow(() -> new NullResultException("Вопроса с заданным id не найдено в БД"));
        Branch branch = branchRepository.findBranchByTitle(branchTitle).orElseThrow(() -> new NullResultException("Отрасли с заданным названием не найдено в БД"));
        Set<Answer> answers = answerRepository.findAnswersByQuestionId(question.getId()).orElse(new HashSet<>());

        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setQuestion(question.getQuestion());
        questionResponse.setBranch_id(branch.getId());
        questionResponse.setAnswer(question.getAnswer());
        Set<AnswerResponse> answerResponses = new HashSet<>();
        for (Answer answer: answers) {
            answerResponses.add(new AnswerResponse(answer.getAnswer(), answer.getQuestion().getId()));
        }
        questionResponse.setAnswers(answerResponses);
        return questionResponse;

    }

    @Override
    public @NonNull Set<Question> findQuestionsByBranch(@NonNull Branch branch) {
        return questionRepository.findQuestionsByBranch(branch).orElseThrow(()-> new NullResultException("Вопроса с заданной отраслью не существует в БД"));
    }

    @Override
    public @NonNull Question findQuestionByBranchAndId(@NonNull Branch branch, @NonNull Long id) {
        return questionRepository.findQuestionByBranchAndId(branch, id).orElseThrow(()-> new NullResultException("Вопроса с заданными параметрами запроса в БД не существует"));
    }



    @Override
    public void addQuestion(@NonNull QuestionRequest questionRequest, @NonNull String branchTitle) {
        if (questionRepository.findQuestionByQuestion(questionRequest.getQuestion()).isPresent())
            throw new DataBaseRefactoringException("Такой вопрос уже существует в БД");

        Branch branch = branchRepository.findBranchByTitle(branchTitle).orElseThrow(() ->new DataBaseRefactoringException("Отрасли с заданным названием в базе данных не существует"));
        Question question = new Question();
        question.setQuestion(questionRequest.getQuestion());
        question.setAnswer(questionRequest.getAnswer());
        question.setBranch(branch);
        questionRepository.save(question);
    }

    @Override
    public @NonNull Question findQuestionByQuestion(@NonNull String question) {
        return questionRepository.findQuestionByQuestion(question).orElseThrow(()-> new NullResultException("Такого вопроса в БД не существует"));
    }

}
