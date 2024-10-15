package com.ForumApplication.QAForum.service.serviceImpl;

import com.ForumApplication.QAForum.model.Answer;
import com.ForumApplication.QAForum.repository.AnswerRepository;
import com.ForumApplication.QAForum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        if (answerRepository.existsById(answer.getAnswerId())) {
            return answerRepository.save(answer);
        }
        return null;
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}
