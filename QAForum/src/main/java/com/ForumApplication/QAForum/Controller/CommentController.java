package com.ForumApplication.QAForum.Controller;

import com.ForumApplication.QAForum.model.Comment;
import com.ForumApplication.QAForum.model.Answer;
import com.ForumApplication.QAForum.model.User;
import com.ForumApplication.QAForum.service.CommentService;
import com.ForumApplication.QAForum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    private final AnswerService answerService;

    @Autowired
    public CommentController(CommentService commentService, AnswerService answerService) {
        this.commentService = commentService;
        this.answerService = answerService;
    }

    // Create a new comment
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        // Check if answer exists
        Answer answer = answerService.getAnswerById(comment.getAnswer().getAnswerId());
        if (answer == null) {
            return ResponseEntity.badRequest().body(null); // Answer not found
        }

        comment.setAnswer(answer);
        Comment createdComment = commentService.createComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    // Get all comments
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // Get a comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return comment != null ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }

    // Update a comment
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setCommentId(id); // Set the ID to the comment
        Comment updatedComment = commentService.updateComment(comment);
        return updatedComment != null ? ResponseEntity.ok(updatedComment) : ResponseEntity.notFound().build();
    }

    // Delete a comment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
