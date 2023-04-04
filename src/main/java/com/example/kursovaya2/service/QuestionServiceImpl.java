package com.example.kursovaya2.service;

import com.example.kursovaya2.Question;
import com.example.kursovaya2.exceptions.BadRequestForAddedQuestion;
import com.example.kursovaya2.exceptions.NotFoundQuestionException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class QuestionServiceImpl implements QuestionService {
    private static List<Question> questions = new ArrayList<>();

    static {
        Question q1 = new Question("Методы каких типов бывают?", "методы бывают статическими и нестатческими");
        Question q2 = new Question("Какие условные операторы вы знаете?", "if-else, switch");
        Question q3 = new Question("Что такое массив?", "это структура данных, которая хранит набор пронумерованных значений одного типа");
        Question q4 = new Question("Что такое конструкторы?", "это специальные методы, которые вызываются при создании объекта");

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
    }

    private Random random = new Random();

    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if(questions.contains(question1)){
            throw new BadRequestForAddedQuestion("Такой вопрос уже существует");
        }

        questions.add(question1);
        return question1;
    }

    public Question remove(String question, String answer) {
        Question q = new Question(question, answer);
        if (questions.removeIf(e -> e.equals(q))) {
            return q;
        } else {
            throw new NotFoundQuestionException("Вопрос не найден");
        }

    }


    public Collection<Question> getAll() {
        return questions;
    }

    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}
