package com.example.doan2.Dto.Answer;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AnswerSpeakingDto {
    private double score;
    private int testId;
    private int userId;
    private  int markerId;
    private  String comment;
    private String answer;
    private MultipartFile audioFile;
}
