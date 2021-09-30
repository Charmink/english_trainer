package com.english_trainer.english_trainer.repository;

import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Branch findBranchByTitle(String title);

}
