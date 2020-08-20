package com.app.repositories;

import com.app.entities.FavouriteSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteSubjectRepository extends JpaRepository<FavouriteSubject,Integer> {
    List<FavouriteSubject> findByUserId(int userId);
}
