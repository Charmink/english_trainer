package com.english_trainer.english_trainer.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "t_question")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String answer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;
}
