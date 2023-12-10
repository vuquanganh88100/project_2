package com.example.doan2.Service;

import com.example.doan2.Entities.PassageEntity;
import com.example.doan2.Entities.ReadingQuesEntity;
import com.example.doan2.Repository.ReadingQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ReadingQuesService {
    @Autowired
    ReadingQuestionRepository readingQuestionRepository;
    @Autowired
    UploadFile uploadFile;

    public String save(MultipartFile file, PassageEntity passageEntity) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            List<ReadingQuesEntity> quesEntities = uploadFile.getQuestionFromExel(inputStream);
            for (ReadingQuesEntity quesEntity : quesEntities) {
                quesEntity.setPassageEntity(passageEntity); // Set the passageEntity
            }
            readingQuestionRepository.saveAll(quesEntities);
            return "Tạo mới thành công";
        } catch (IOException e) {
            // Handle IOException appropriately (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return "Failed to save data";
        }
    }
}