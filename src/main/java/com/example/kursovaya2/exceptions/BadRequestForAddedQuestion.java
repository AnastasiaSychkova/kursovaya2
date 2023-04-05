package com.example.kursovaya2.exceptions;

public class BadRequestForAddedQuestion extends RuntimeException {
    public BadRequestForAddedQuestion(String massage) {
        super(massage);
    }
}
