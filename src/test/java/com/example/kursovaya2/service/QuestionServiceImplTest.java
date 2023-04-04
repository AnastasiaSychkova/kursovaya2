package com.example.kursovaya2.service;

import com.example.kursovaya2.Question;
import com.example.kursovaya2.exceptions.BadRequestForAddedQuestion;
import com.example.kursovaya2.exceptions.NotFoundQuestionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {QuestionServiceImpl.class})
@ExtendWith(SpringExtension.class)
class QuestionServiceImplTest {
    @Autowired
    QuestionService questionService;
    private static final Question Q = new Question("Дайте определение сеттерам", "это метод, который изменяет значение поля");
    private static final Question Q1 = new Question("Методы каких типов бывают?", "методы бывают статическими и нестатческими");
    private static final Question Q2 = new Question("Какие условные операторы вы знаете?", "if-else, switch");
    private static final Question Q3 = new Question("Что такое массив?", "это структура данных, которая хранит набор пронумерованных значений одного типа");
    private static final Question Q4 = new Question("Что такое конструкторы?", "это специальные методы, которые вызываются при создании объекта");
    private static final String ANSWER = "Дайте определение сеттерам";
    private static final String QUESTION = "это метод, который изменяет значение поля";
    private static final Collection<Question> QUESTIONS = new ArrayList<>();

    @Test
    void addSuccess() {
        String answer = "Дайте определение переменной";
        String question = "это некоторый контейнер,  в котором может храниться значение для дальнейшего использования в программе";

        Question question1 = new Question(answer, question);
        QUESTIONS.add(question1);
        Question expected = question1;

        Question actual = questionService.add(answer, question);
        assertEquals(expected, actual);
    }

    @Test
    void addWithBadRequestForAddedQuestion() {
        String answer = "Методы каких типов бывают?";
        String question = "методы бывают статическими и нестатческими";


        String expected = "Такой вопрос уже существует";


        Exception exception = assertThrows(
                BadRequestForAddedQuestion.class,
                () -> {
                    questionService.add(answer, question);
                }
        );
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void removeSuccess() {

        QUESTIONS.add(Q);
        QUESTIONS.remove(Q);
        Question expected = Q;

        questionService.add(ANSWER, QUESTION);
        Question actual = questionService.remove(ANSWER, QUESTION);
        assertEquals(expected, actual);
    }

    @Test
    void removeSuccessWithNotFoundQuestionException() {

        String expectedMassage = "Вопрос не найден";

        Exception exception = assertThrows(
                NotFoundQuestionException.class,
                () -> {
                    questionService.remove(ANSWER, QUESTION);
                }
        );
        assertEquals(expectedMassage, exception.getMessage());
    }

    @Test
    void getAll() {

        QUESTIONS.add(Q1);
        QUESTIONS.add(Q2);
        QUESTIONS.add(Q3);
        QUESTIONS.add(Q4);

        Collection<Question> actual = questionService.getAll();
        assertEquals(QUESTIONS, actual);

    }
}