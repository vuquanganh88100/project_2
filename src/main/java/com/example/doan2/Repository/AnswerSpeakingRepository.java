package com.example.doan2.Repository;

import com.example.doan2.Entities.AnswerSpeakingEntity;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.SpeakingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerSpeakingRepository extends JpaRepository<AnswerSpeakingEntity,Integer> {

}
