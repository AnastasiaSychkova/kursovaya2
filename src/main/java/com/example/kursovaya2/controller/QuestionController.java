package com.example.kursovaya2.controller;

import com.example.kursovaya2.Question;
import com.example.kursovaya2.exceptions.BadRequestForAddedQuestion;
import com.example.kursovaya2.exceptions.NotFoundQuestionException;
import com.example.kursovaya2.exceptions.WrongSizeQuestionsException;
import com.example.kursovaya2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundQuestionException.class)
    public String handleException(NotFoundQuestionException e) {
        return String.format("%s NotFoundQuestionException %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestForAddedQuestion.class)
    public String handleException(BadRequestForAddedQuestion e) {
        return String.format("%s BadRequestForAddedQuestion %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
    @RequestMapping("/add")
    public Question add(@RequestParam String question, String answer) {
        return questionService.add(question, answer);
    }

    @RequestMapping("/remove")
    public Question remove(@RequestParam String question, String answer) {
        return questionService.remove(question, answer);
    }

    @RequestMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
