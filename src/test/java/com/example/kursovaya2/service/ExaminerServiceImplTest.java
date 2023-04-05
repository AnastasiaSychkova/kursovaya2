package com.example.kursovaya2.service;

import com.example.kursovaya2.Question;
import com.example.kursovaya2.exceptions.WrongSizeQuestionsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ExaminerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ExaminerServiceImplTest {
    @Autowired
    ExaminerService examinerService;

    @MockBean
    QuestionService questionService;

    Random random = new Random();
    private static final List<Question> QUESTIONS = new ArrayList<>();
    private static final Question Q1 = new Question("Методы каких типов бывают?", "методы бывают статическими и нестатческими");
    private static final Question Q2 = new Question("Какие условные операторы вы знаете?", "if-else, switch");
    private static final Question Q3 = new Question("Что такое массив?", "это структура данных, которая хранит набор пронумерованных значений одного типа");
    private static final Question Q4 = new Question("Что такое конструкторы?", "это специальные методы, которые вызываются при создании объекта");
    @Test
    void getQuestion() {
        int amount = 2;
        QUESTIONS.add(Q1);
        QUESTIONS.add(Q2);
        QUESTIONS.add(Q3);
        QUESTIONS.add(Q4);

        when(questionService.getAll()).thenReturn(QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(QUESTIONS.get(random.nextInt(QUESTIONS.size())));

        Collection<Question> actual = examinerService.getQuestion(amount);
        assertTrue(!actual.isEmpty());
    }
    @Test
    void getQuestionWithWrongSizeQuestionsException() {
        int amount = 10;
        QUESTIONS.add(Q1);
        QUESTIONS.add(Q2);
        QUESTIONS.add(Q3);
        QUESTIONS.add(Q4);

        when(questionService.getAll()).thenReturn(QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(QUESTIONS.get(random.nextInt(QUESTIONS.size())));
        String expected = "Введенное число превышает количество вопросов";

        Exception exception = assertThrows(
                WrongSizeQuestionsException.class,
                () -> examinerService.getQuestion(amount)
        );
        assertEquals(expected, exception.getMessage());
    }
}