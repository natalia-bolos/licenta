package com.app.repositories;

import com.app.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Integer> {
    List<Skill> findByUserId(int userId);
}
