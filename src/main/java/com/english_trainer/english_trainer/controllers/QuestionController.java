package com.english_trainer.english_trainer.controllers;

import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.payload.QuestionRequest;
import com.english_trainer.english_trainer.services.IBranchService;
import com.english_trainer.english_trainer.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/branch/{branch_id}/question")
public class QuestionController {

    private final IQuestionService iquestionService;
    private final IBranchService branchService;


    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long branch_id, @PathVariable Long id){
        Question question = iquestionService.getQuestion(id, branch_id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addQuestion(@RequestBody QuestionRequest questionRequest)
    {
        iquestionService.addQuestion(questionRequest);
    }
}
