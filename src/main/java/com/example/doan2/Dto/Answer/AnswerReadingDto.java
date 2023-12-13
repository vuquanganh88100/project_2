package com.example.doan2.Dto.Answer;

import lombok.Data;

import java.util.List;

@Data
public class AnswerReadingDto {
    private Integer id;
    private Double score;
    private Integer user_id;
    private Integer test_id;
    private List<String> selectedAns;
    private  List<String>correctAns;
    private List<Boolean> answerResults;
}
