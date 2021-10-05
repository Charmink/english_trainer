package com.english_trainer.english_trainer.controllers;

import com.english_trainer.english_trainer.payload.AnswerRequest;
import com.english_trainer.english_trainer.services.IAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answer")
public class AnswerController {

    private final IAnswerService iAnswerService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addAnswer(@RequestBody AnswerRequest answerRequest){
        iAnswerService.addAnswer(answerRequest);
    }

}
