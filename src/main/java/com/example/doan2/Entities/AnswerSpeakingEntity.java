package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="result_speaking",schema = "doan2")
public class AnswerSpeakingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "score")
    private Double score;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marker_id", referencedColumnName = "user_id")
    private UserEntity marker;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private SpeakingEntity test;
    @Column(name="comment")
    private  String comment;
    @Column(name="answer_content")
    private  String audio;
}
