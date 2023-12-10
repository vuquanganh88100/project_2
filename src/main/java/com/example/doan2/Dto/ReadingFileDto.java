package com.example.doan2.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReadingFileDto {
    private MultipartFile file;
}
