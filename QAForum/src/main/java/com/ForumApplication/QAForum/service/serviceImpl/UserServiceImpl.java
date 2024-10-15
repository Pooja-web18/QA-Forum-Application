package com.ForumApplication.QAForum.service.serviceImpl;

import com.ForumApplication.QAForum.Exception.UserException;
import com.ForumApplication.QAForum.model.User;
import com.ForumApplication.QAForum.repository.UserRepository; // Make sure this import is correct
import com.ForumApplication.QAForum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }


    @Override
    public User getUserByName(String username) {
        return userRepository.findByUsername(username); // Ensure this method exists in UserRepository
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user); // You may want to check if the user exists first
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Ensure this method exists in UserRepository
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId); // Ensure this method exists in UserRepository
    }
}
