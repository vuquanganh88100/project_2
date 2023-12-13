package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "speaking_question",schema = "doan2")
public class SpeakingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="content")
    private String content;
    @Column(name="img")
    private String img;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asker_id", referencedColumnName = "user_id")
    private UserEntity user;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerSpeakingEntity> answerSpeakingEntities = new ArrayList<>();
}
