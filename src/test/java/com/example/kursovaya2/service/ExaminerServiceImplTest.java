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

@ContextConfiguration(classes = {ExaminerServiceImpl.class, QuestionServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ExaminerServiceImplTest {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExaminerService examinerService;

    @Test
    void getQuestion() {
        int amount = 2;
        Collection<Question> actual = examinerService.getQuestion(amount);
        assertFalse(actual.isEmpty());
    }

    @Test
    void getQuestionWithWrongSizeQuestionsException() {
        int amount = 10;
        String expected = "Введенное число превышает количество вопросов";

        Exception exception = assertThrows(
                WrongSizeQuestionsException.class,
                () -> examinerService.getQuestion(amount)
        );
        assertEquals(expected, exception.getMessage());
    }
}