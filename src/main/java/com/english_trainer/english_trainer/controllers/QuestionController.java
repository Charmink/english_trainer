package com.english_trainer.english_trainer.controllers;

import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.services.IQuestionService;
import com.english_trainer.english_trainer.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService iquestionService;

    @GetMapping("/question")
    @ResponseStatus(HttpStatus.OK)
    public Question getQuestion(@RequestParam(name = "id", required = true) Long id){
        return iquestionService.findQuestionById(id);
    }
}
