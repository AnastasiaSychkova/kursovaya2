package com.example.kursovaya2;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestion(int amount) {

    }
}
