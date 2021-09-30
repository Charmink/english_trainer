package com.english_trainer.english_trainer.controllers;

import com.english_trainer.english_trainer.domain.User;
import com.english_trainer.english_trainer.repository.UserRepository;
import com.english_trainer.english_trainer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (userRepository.findByUsername(userForm.getUsername()) != null){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        userService.saveUser(userForm);


        return "redirect:/";
    }
}
