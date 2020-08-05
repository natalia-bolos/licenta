package com.app.repositories;

import com.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsernameOrMailAndPassword(String username, String mail, String password);
    Optional<User> findByUsernameOrMail(String userOrPass, String passOrUser);

    Boolean existsByUsername(String username);

    Boolean existsByMail(String email);

}
