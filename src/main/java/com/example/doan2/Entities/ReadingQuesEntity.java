package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="reading_question",schema = "doan2")
@Data
public class ReadingQuesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reading_id", referencedColumnName = "id")
    private PassageEntity passageEntity;
    @Column(name="number_question")
    private Integer number_question;
    @Column(name="passage")
    private Integer passage;
    @Column(name="type")
    private String type;
    @Column(name="content")
    private String content;
    @Column(name="A")
    private String A;
    @Column(name="B")
    private String B;
    @Column(name="C")
    private String C;
    @Column(name="D")
    private String D;
    @Column (name="correct")
    private String correct;
}
