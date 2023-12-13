package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(schema = "doan2",name = "ielts_writing")
public class WritingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="part1")
    private String part1;
    @Column(name="part2")
    private String part2;
    @Column(name="img")
    private String img;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asker", referencedColumnName = "user_id")
    private UserEntity user;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerWritingEntity> answerWritingEntities = new ArrayList<>();
}
