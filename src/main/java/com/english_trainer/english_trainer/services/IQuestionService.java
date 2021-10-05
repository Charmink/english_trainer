package com.english_trainer.english_trainer.services;

import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.payload.QuestionRequest;
import com.english_trainer.english_trainer.payload.QuestionResponse;
import lombok.NonNull;

import java.util.Set;

public interface IQuestionService {
    @NonNull
    QuestionResponse getQuestion(@NonNull Long id, @NonNull String branch_title);
    @NonNull
    Set<Question> findQuestionsByBranch(@NonNull Branch branch);
    @NonNull
    Question findQuestionByBranchAndId(@NonNull Branch branch, @NonNull Long id);
    void addQuestion(@NonNull QuestionRequest questionRequest, @NonNull String branchTitle);
    @NonNull
    Question findQuestionByQuestion(@NonNull String question);
}
