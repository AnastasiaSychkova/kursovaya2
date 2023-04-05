package com.example.kursovaya2.exceptions;

public class WrongSizeQuestionsException extends RuntimeException {
    public WrongSizeQuestionsException(String massage) {
        super(massage);
    }
}
