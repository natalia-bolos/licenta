package com.app.services;

import com.app.entities.User;
import com.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User logIn(String username, String password, String mail) {
        User loggedIn = userRepository.findByMailAndPassword(mail, password);
        if (loggedIn == null) {
            loggedIn = userRepository.findByUsernameAndPassword(username, password);
        }
        return loggedIn;
    }
}
