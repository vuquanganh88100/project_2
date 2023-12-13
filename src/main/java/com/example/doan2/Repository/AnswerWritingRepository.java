package com.example.doan2.Repository;

import com.example.doan2.Entities.AnswerReadingEntity;
import com.example.doan2.Entities.AnswerWritingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerWritingRepository extends JpaRepository<AnswerWritingEntity,Integer> {
    @Query("SELECT w FROM AnswerWritingEntity w WHERE w.user.userId = :userId")
    List<AnswerWritingEntity> findResultsByUserId(int userId);
}
