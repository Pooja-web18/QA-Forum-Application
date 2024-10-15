package com.ForumApplication.QAForum.service;

import com.ForumApplication.QAForum.model.Answer;

import java.util.List;

public interface AnswerService {
    Answer saveAnswer(Answer answer);
    List<Answer> getAllAnswers();
    Answer getAnswerById(Long id);
    Answer updateAnswer(Answer answer);
    void deleteAnswer(Long id);
}
