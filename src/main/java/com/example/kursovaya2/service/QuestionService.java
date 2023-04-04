package com.example.kursovaya2.service;

import com.example.kursovaya2.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
