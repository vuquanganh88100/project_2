package com.example.doan2.Repository;

import com.example.doan2.Entities.ConfirmTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmTokenRepository extends JpaRepository<ConfirmTokenEntity,Integer> {
    ConfirmTokenEntity findByConfirmToken(String confirmToken);
}
