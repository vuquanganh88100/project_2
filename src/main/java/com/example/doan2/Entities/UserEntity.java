package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user",schema = "doan2")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_role")
    private String userRole;
    @Column(name="user_enable")
    private boolean userEnable;
    @Column(name="user_email")
    private String userEmail;
    @Column(name = "user_password")
    private String userPassword;
    @OneToOne(mappedBy = "userEntity")
    private  ConfirmTokenEntity confirmTokenEntity;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerReadingEntity> answerReadingEntities = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WritingEntity> writingEntities = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerWritingEntity> answerWritingEntities = new ArrayList<>();
    @OneToMany(mappedBy = "marker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerWritingEntity> answerWritingEntities1 = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SpeakingEntity> speakingEntities = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerSpeakingEntity> answerSpeakingEntities = new ArrayList<>();
    @OneToMany(mappedBy = "marker", cascade = {CascadeType.PERSIST, CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<AnswerSpeakingEntity> answerSpeakingEntities1 = new ArrayList<>();


}