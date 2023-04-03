package com.example.kursovaya2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("/add")
    public Question add(@RequestParam String question, String answer){

    }
    @RequestMapping("/remove")
    public Question remove(@RequestParam String question, String answer){

    }
    @RequestMapping
    public Collection<Question> getQuestions(){

    }
}
