package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "doan2", name = "result_writing")
public class AnswerWritingEntity {
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
    private WritingEntity test;
    @Column(name="comment")
    private  String comment;
    @Column(name="task1")
    private  String task1;
    @Column(name="task2")
    private  String task2;
}
