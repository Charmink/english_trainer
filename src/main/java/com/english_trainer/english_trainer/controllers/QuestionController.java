package com.english_trainer.english_trainer.controllers;

import com.english_trainer.english_trainer.payload.QuestionRequest;
import com.english_trainer.english_trainer.payload.QuestionResponse;
import com.english_trainer.english_trainer.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/branch/{branchTitle}/question")
public class QuestionController {

    private final IQuestionService iquestionService;


    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> getQuestionById(@PathVariable String branchTitle, @PathVariable Long id){
        QuestionResponse questionResponse = iquestionService.getQuestion(id, branchTitle);
        return new ResponseEntity<>(questionResponse, HttpStatus.OK);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addQuestion(@RequestBody QuestionRequest questionRequest, @PathVariable String branchTitle)
    {
        iquestionService.addQuestion(questionRequest, branchTitle);
    }
}
