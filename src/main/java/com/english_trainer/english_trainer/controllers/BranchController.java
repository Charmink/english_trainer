package com.english_trainer.english_trainer.controllers;

import com.english_trainer.english_trainer.domain.Branch;
import com.english_trainer.english_trainer.domain.Question;
import com.english_trainer.english_trainer.payload.BranchResponse;
import com.english_trainer.english_trainer.services.BranchService;
import com.english_trainer.english_trainer.services.IBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branch")
public class BranchController {
    private final IBranchService branchService;

    @GetMapping("/{title}")
    @ResponseStatus(HttpStatus.OK)
    public BranchResponse getBranch(@PathVariable String title){
        return branchService.findBranchByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addBranch(@RequestBody Branch branch){
        branchService.addBranch(branch);

    }


}
