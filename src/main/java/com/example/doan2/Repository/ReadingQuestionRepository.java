package com.example.doan2.Repository;

import com.example.doan2.Entities.ReadingQuesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReadingQuestionRepository extends JpaRepository<ReadingQuesEntity,Integer> {

}
