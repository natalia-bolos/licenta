package com.app.services;

import com.app.entities.User;
import com.app.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    private static final String regex = "^(.+)@(.+)$";

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
        return userRepository.findByUsernameOrMailAndPassword(username,mail, password).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username or email : " + username+" "+mail));

    }

    public boolean testMail(String mail){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }
}
