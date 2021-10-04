package com.english_trainer.english_trainer.payload;

import com.english_trainer.english_trainer.domain.Question;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data
public class BranchResponse {
    @NotBlank
    private String title;

    @NotBlank
    private Set<Question> questions = new HashSet<>();
}
