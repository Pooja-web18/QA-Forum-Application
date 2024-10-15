package com.ForumApplication.QAForum.Controller;

import com.ForumApplication.QAForum.model.Answer;
import com.ForumApplication.QAForum.model.Question;
import com.ForumApplication.QAForum.model.User;
import com.ForumApplication.QAForum.service.AnswerService;
import com.ForumApplication.QAForum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {

        if (answer.getUser() == null || answer.getUser().getUserId() == null) {
            return ResponseEntity.badRequest().body(null); // Return a bad request response
        }

        if (answer.getQuestion() == null || answer.getQuestion().getQuestionId() == null) {
            return ResponseEntity.badRequest().body(null); // Return a bad request response
        }

        // Check if the question exists
        Question existingQuestion = questionService.getQuestionById(answer.getQuestion().getQuestionId());
        if (existingQuestion == null) {
            return ResponseEntity.badRequest().body(null); // Return a bad request response
        }

        // Set the existing question to the answer
        answer.setQuestion(existingQuestion);

        // Save the answer
        Answer createdAnswer = answerService.saveAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.getAllAnswers();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long answerId) {
        Answer answer = answerService.getAnswerById(answerId);
        return answer != null ? new ResponseEntity<>(answer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Long answerId, @RequestBody Answer answer) {
        answer.setAnswerId(answerId);
        Answer updatedAnswer = answerService.updateAnswer(answer);
        return updatedAnswer != null ? new ResponseEntity<>(updatedAnswer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
