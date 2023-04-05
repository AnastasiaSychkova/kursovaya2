package com.example.kursovaya2.service;

import com.example.kursovaya2.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestion(int amount);
}
