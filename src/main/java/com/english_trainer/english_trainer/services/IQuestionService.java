package com.english_trainer.english_trainer.services;

import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.payload.QuestionRequest;
import lombok.NonNull;

import java.util.Set;

public interface IQuestionService {
    @NonNull
    Question getQuestion(@NonNull Long id, @NonNull Long branch_id);
    @NonNull
    Set<Question> findQuestionsByBranch(@NonNull Branch branch);
    @NonNull
    Question findQuestionByBranchAndId(@NonNull Branch branch, @NonNull Long id);
    void addQuestion(@NonNull QuestionRequest questionRequest);
    @NonNull
    Question findQuestionByQuestion(@NonNull String question);
}
