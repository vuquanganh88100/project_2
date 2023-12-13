package com.example.doan2.Repository;

import com.example.doan2.Entities.AnswerReadingEntity;
import com.example.doan2.Entities.AnswerWritingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerReadingRepository extends JpaRepository<AnswerReadingEntity,Integer> {
    @Query("SELECT r FROM AnswerReadingEntity r WHERE r.user.userId = :userId")
    List<AnswerReadingEntity> findResultsByUserId(int userId);
}
