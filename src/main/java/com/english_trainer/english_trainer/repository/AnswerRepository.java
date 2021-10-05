package com.english_trainer.english_trainer.repository;

import com.english_trainer.english_trainer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Optional<Set<Answer>> findAnswersByQuestionId(Long questionId);
    Optional<Answer> findAnswerByAnswer(String answer);
}
