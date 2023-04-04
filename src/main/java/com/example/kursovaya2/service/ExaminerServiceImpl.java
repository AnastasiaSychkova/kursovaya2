package com.example.kursovaya2.service;

import com.example.kursovaya2.Question;
import com.example.kursovaya2.exceptions.WrongSizeQuestionsException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    //private Random random;
    private QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestion(int amount) {
        if(amount > questionService.getAll().size()){
            throw new WrongSizeQuestionsException("Введенное число превышает количество вопросов");
        }

        Set<Question> questionList = new HashSet<>();
        while (questionList.size() < amount) {
            questionList.add(questionService.getRandomQuestion());
        }
        return questionList;
    }
}
