package com.example.doan2.Repository;

import com.example.doan2.Entities.AnswerSpeakingEntity;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.SpeakingEntity;
import com.example.doan2.Entities.WritingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeakingRepository extends JpaRepository<SpeakingEntity,Integer> {
    SpeakingEntity findById(int id);
    @Query("SELECT s FROM AnswerSpeakingEntity s JOIN s.test iw WHERE iw.user.userId = :askerId")
    List<AnswerSpeakingEntity> findResultsByAsker(@Param("askerId") int askerId);
}
