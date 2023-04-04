package com.example.kursovaya2.exceptions;

public class NotFoundQuestionException extends RuntimeException {
    public NotFoundQuestionException(String massage) {
        super(massage);
    }
}
