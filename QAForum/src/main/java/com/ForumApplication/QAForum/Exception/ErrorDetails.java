package com.ForumApplication.QAForum.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String description;

    public void setTimestamp(LocalDateTime now) {
    }

    public void setMessage(String message) {
    }

    public void setDescription(String s) {

    }
}