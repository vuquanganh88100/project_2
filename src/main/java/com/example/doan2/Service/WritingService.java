package com.example.doan2.Service;

import com.example.doan2.Dto.WritingDto;
import com.example.doan2.Entities.UserEntity;
import com.example.doan2.Entities.WritingEntity;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Repository.WritingRepository;
import com.example.doan2.Utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service

public class WritingService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WritingRepository writingRepository;

    public String save(WritingDto writingDto
                       ) throws IOException {
        String filePath = String.valueOf(FileUtils.saveFileFromMultiPartFile(writingDto.getImgFile()));
        WritingEntity writingEntity=new WritingEntity();
        writingEntity.setImg(filePath);
        writingEntity.setPart1(writingDto.getAsk1());
        writingEntity.setPart2(writingDto.getAsk2());
        UserEntity user=userRepository.getById(writingDto.getUserId());
        writingEntity.setUser(user);
        writingRepository.save(writingEntity);
        return "Thanh cong";
    }

    public WritingEntity findWritingById(int id) {
        Optional<WritingEntity> writingOptional = Optional.ofNullable(writingRepository.findById(id));
        return writingOptional.orElse(null); // or handle as needed
    }

}
