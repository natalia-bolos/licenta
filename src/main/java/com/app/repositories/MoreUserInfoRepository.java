package com.app.repositories;

import com.app.entities.MoreUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoreUserInfoRepository extends JpaRepository<MoreUserInfo,Integer> {
    MoreUserInfo findByUserId(int userId);
}
