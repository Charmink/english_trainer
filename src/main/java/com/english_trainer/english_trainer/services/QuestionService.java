package com.english_trainer.english_trainer.services;


import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.exceptions.NullResultException;
import com.english_trainer.english_trainer.payload.QuestionRequest;
import com.english_trainer.english_trainer.repository.BranchRepository;
import com.english_trainer.english_trainer.repository.QuestionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{
    private final QuestionRepository questionRepository;
    private final BranchRepository branchRepository;

    @Override
    public @NonNull Question getQuestion(@NonNull Long id, @NonNull Long branch_id){
        Question question = questionRepository.findById(id).orElseThrow(() -> new NullResultException("Ничего не найдено по заданному id"));
        Branch branch = branchRepository.findById(branch_id).orElseThrow(() -> new NullResultException("Ничего не найдено по заданному id"));
        if(question.getBranch().getId().equals(branch.getId())){
            return question;
        }
        throw new NullResultException("Ничего не найдено по заданному id");
    }

    @Override
    public @NonNull Set<Question> findQuestionsByBranch(@NonNull Branch branch) {
        return questionRepository.findQuestionsByBranch(branch).orElseThrow(()-> new NullResultException("Ничего не найдено по заданному запросу"));
    }

    @Override
    public @NonNull Question findQuestionByBranchAndId(@NonNull Branch branch, @NonNull Long id) {
        return questionRepository.findQuestionByBranchAndId(branch, id).orElseThrow(()-> new NullResultException("Ничего не найдено по заданному запросу"));
    }



    @Override
    public void addQuestion(@NonNull QuestionRequest questionRequest) {
        if (questionRepository.findQuestionByQuestion(questionRequest.getQuestion()).isPresent())
            return;

        Branch branch = branchRepository.findBranchById(questionRequest.getBranch_id()).orElse(null);
        if (branch == null)
            return;
        Question question = new Question();
        question.setQuestion(questionRequest.getQuestion());
        question.setAnswer(questionRequest.getAnswer());
        question.setBranch(branch);
        questionRepository.save(question);
    }

    @Override
    public @NonNull Question findQuestionByQuestion(@NonNull String question) {
        return questionRepository.findQuestionByQuestion(question).orElseThrow(()-> new NullResultException("Ничего не найдено по заданному запросу"));
    }

}
