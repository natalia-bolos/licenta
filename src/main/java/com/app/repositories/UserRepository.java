package com.app.repositories;

import com.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsernameAndPassword(String username,String password);
    User findByMailAndPassword(String mail,String password);
}
