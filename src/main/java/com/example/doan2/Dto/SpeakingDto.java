package com.example.doan2.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SpeakingDto {
    private Integer userId;
    private String image;
    private MultipartFile imgFile ;
    private String content;
}
