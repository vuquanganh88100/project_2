package com.example.doan2.Dto.Answer;

import lombok.Data;

@Data
public class AnswerWritingDto {
    private  Double score;
    private  Integer userId;
    private Integer markerId;
    private String comment;
    private  Integer testId;
    private String task1;
    private  String task2;
}
