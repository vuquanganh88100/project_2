package com.example.doan2.Repository;

import com.example.doan2.Entities.PassageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PassageRepository extends JpaRepository<PassageEntity,Integer> {
    @Query("SELECT rq.content, " +
            "CASE :passage " +
            "   WHEN 1 THEN rp.passage1 " +
            "   WHEN 2 THEN rp.passage2 " +
            "   WHEN 3 THEN rp.passage3 " +
            "   ELSE NULL END AS passage, " +
            "rq.id, rq.type,rq.number_question,rq.A,rq.B,rq.C,rq.D,rq.correct " +
            "FROM ReadingQuesEntity rq " +
            "JOIN rq.passageEntity rp " +
            "WHERE rp.id = :readingId AND rq.passage = :passage")
    List<Object[]> findContentAndPassageByReadingIdAndPassage(
            @Param("readingId") Integer readingId,
            @Param("passage") Integer passage);
}
