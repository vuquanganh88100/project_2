package com.example.doan2.Repository;

import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.WritingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WritingRepository extends JpaRepository<WritingEntity, Integer> {
    WritingEntity findById(int id);
    @Query("SELECT rw FROM AnswerWritingEntity rw JOIN rw.test iw WHERE iw.user.userId = :askerId")
    List<AnswerWritingEntity> findResultsByAsker(@Param("askerId") int askerId);
}
