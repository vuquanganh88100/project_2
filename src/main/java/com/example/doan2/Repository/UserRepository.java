package com.example.doan2.Repository;

import com.example.doan2.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserEmailIgnoreCase(String userEmail);

    @Query("SELECT u.userId FROM UserEntity u WHERE LOWER(u.userEmail) = LOWER(:userEmail)")
    Integer findUserIdByUserEmailIgnoreCase(@Param("userEmail") String userEmail);
}
