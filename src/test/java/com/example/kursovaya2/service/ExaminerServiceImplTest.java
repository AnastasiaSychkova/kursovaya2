package com.example.kursovaya2.service;

import com.example.kursovaya2.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

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
    @Test
    void getQuestion() {
      /*  List<Question> questions = new ArrayList<>();
        Question q1 = new Question("rrrrr", "ppppp");
        Question q2 = new Question("oooo", "lllll");
        Question q3 = new Question("wwww", "eeee");
        Question q4 = new Question("qqqqq", "xxxxx");
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);

        when(questionService.getRandomQuestion()).thenReturn(questions.get(random.nextInt(questions.size())));

        Collection<Question> actual = examinerService.getQuestion(2);
        assertTrue(actual);
   /*/ }
}