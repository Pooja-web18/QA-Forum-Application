package com.ForumApplication.QAForum.Exception;

public class UserException extends RuntimeException {
    public UserException() {}

    public UserException(String message) {
        super(message);
    }
}
