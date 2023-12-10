package com.example.doan2.Repository;

import com.example.doan2.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserEmailIgnoreCase(String userEmail);
}
