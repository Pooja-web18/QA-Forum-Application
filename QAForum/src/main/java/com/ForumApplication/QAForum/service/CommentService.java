package com.ForumApplication.QAForum.service;

import com.ForumApplication.QAForum.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment getCommentById(Long commentId);
    List<Comment> getAllComments();
    Comment updateComment(Comment comment);
    void deleteComment(Long commentId);
}
