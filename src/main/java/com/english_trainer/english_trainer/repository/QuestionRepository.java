package com.english_trainer.english_trainer.repository;

import com.english_trainer.english_trainer.domain.Question;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findQuestionById(Long id);
    Question findQuestionByQuestion(String question);
}
