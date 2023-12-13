package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "result_reading",schema = "doan2",catalog = "")
@Data
public class AnswerReadingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="score")
    private  Double score;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="test_id",referencedColumnName = "id")
    private  PassageEntity passageEntity;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    private  UserEntity user;
}
