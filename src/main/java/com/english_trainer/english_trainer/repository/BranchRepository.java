package com.english_trainer.english_trainer.repository;

import com.english_trainer.english_trainer.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findBranchByTitle(String title);
    Optional<Branch> findBranchById(Long id);


}
