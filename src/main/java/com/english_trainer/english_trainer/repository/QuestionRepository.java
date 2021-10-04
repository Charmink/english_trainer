package com.english_trainer.english_trainer.repository;

import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.domain.Question;
import lombok.NonNull;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByBranchId(Long id);
    Optional<Set<Question>> findQuestionsByBranch(Branch branch);
    Optional<Question> findQuestionByBranchAndId(Branch branch, Long id);
    Optional<Question> findQuestionByQuestion(String question);
}
