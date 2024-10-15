package com.ForumApplication.QAForum.service;

import com.ForumApplication.QAForum.model.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);
    Question getQuestionById(Long questionId);
    List<Question> getAllQuestions();
    Question updateQuestion(Question question);
    void deleteQuestion(Long questionId);
}
