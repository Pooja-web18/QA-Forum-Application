package com.ForumApplication.QAForum.Exception;

public class AnswerException extends RuntimeException {
    public AnswerException() {}

    public AnswerException(String message) {
        super(message);
    }
}
