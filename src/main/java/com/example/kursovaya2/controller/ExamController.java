package com.example.kursovaya2.controller;

import com.example.kursovaya2.service.ExaminerService;
import com.example.kursovaya2.Question;
import com.example.kursovaya2.exceptions.WrongSizeQuestionsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController

public class ExamController {
    private ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongSizeQuestionsException.class)
    public String handleException(WrongSizeQuestionsException e) {
        return String.format("%s WrongSizeQuestionsException %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @RequestMapping("/exam/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }
}
