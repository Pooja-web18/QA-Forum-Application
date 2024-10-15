package com.ForumApplication.QAForum.service;
import com.ForumApplication.QAForum.model.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);
    User login(String username, String password);
    User getUserByName(String username);
    User updateUser(User user);
    List<User> getAllUsers();

    void deleteUser(Long userId);
}
