package com.example.doan2.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class WritingDto {
    public Integer id;
    public String ask1;
    public String ask2;
    public Integer userId;
    private String image;
    private MultipartFile imgFile ;
}
