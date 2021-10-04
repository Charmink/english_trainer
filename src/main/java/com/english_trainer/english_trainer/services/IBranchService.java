package com.english_trainer.english_trainer.services;

import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.payload.BranchResponse;
import lombok.NonNull;

public interface IBranchService {
    @NonNull
    BranchResponse findBranchByTitle(String title);

    @NonNull
    Branch findBranchById(Long id);

    void addBranch(@NonNull Branch branch);
}
