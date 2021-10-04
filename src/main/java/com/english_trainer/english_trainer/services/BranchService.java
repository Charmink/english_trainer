package com.english_trainer.english_trainer.services;

import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.exceptions.NullResultException;
import com.english_trainer.english_trainer.payload.BranchResponse;
import com.english_trainer.english_trainer.repository.BranchRepository;
import com.english_trainer.english_trainer.repository.QuestionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BranchService implements IBranchService {

    private final BranchRepository branchRepository;
    private final QuestionRepository questionRepository;

    @Override
    public @NonNull BranchResponse findBranchByTitle(String title) {
        Branch branch = branchRepository.findBranchByTitle(title).orElseThrow(()-> new NullResultException("По данному запросу ничего не найдено"));

        Set<Question> questions = questionRepository.findQuestionsByBranch(branch).orElse(new HashSet<>());

        BranchResponse branchResponse = new BranchResponse();
        branchResponse.setTitle(branch.getTitle());
        branchResponse.setQuestions(questions);
        return branchResponse;
    }

    @Override
    public @NonNull Branch findBranchById(Long id) {
        return branchRepository.findBranchById(id).orElseThrow(()->new NullResultException("По данному запросу ничего не найдено"));
    }

    @Override
    public void addBranch(@NonNull Branch branch) {
        Branch branchBD = branchRepository.findBranchByTitle(branch.getTitle()).orElse(null);
        if (branchBD == null){
            branchRepository.save(branch);
        }
    }
}
