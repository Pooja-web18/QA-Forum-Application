package com.ForumApplication.QAForum.Controller;

import com.ForumApplication.QAForum.model.Question;
import com.ForumApplication.QAForum.model.User;
import com.ForumApplication.QAForum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        if (question.getUser() == null || question.getUser().getUserId() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Question createdQuestion = questionService.createQuestion(question);

        Question responseQuestion = new Question();
        responseQuestion.setQuestionId(createdQuestion.getQuestionId());
        responseQuestion.setTitle(createdQuestion.getTitle());
        responseQuestion.setContent(createdQuestion.getContent());

        User user = new User();
        user.setUserId(createdQuestion.getUser().getUserId());
        responseQuestion.setUser(user);

        return ResponseEntity.status(201).body(responseQuestion);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getQuestionById(id);
        return question != null ? ResponseEntity.ok(question) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        question.setQuestionId(id);
        Question updatedQuestion = questionService.updateQuestion(question);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
