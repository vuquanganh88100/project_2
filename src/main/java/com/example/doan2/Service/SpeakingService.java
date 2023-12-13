package com.example.doan2.Service;

import com.example.doan2.Dto.SpeakingDto;
import com.example.doan2.Dto.WritingDto;
import com.example.doan2.Entities.SpeakingEntity;
import com.example.doan2.Entities.UserEntity;
import com.example.doan2.Entities.WritingEntity;
import com.example.doan2.Repository.SpeakingRepository;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class SpeakingService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SpeakingRepository speakingRepository;
    public String save(SpeakingDto speakingDto
                       ) throws IOException {
        String filePath = String.valueOf(FileUtils.saveFileFromMultiPartFile(speakingDto.getImgFile()));
        SpeakingEntity speakingEntity=new SpeakingEntity();
        speakingEntity.setContent(speakingEntity.getContent());
        speakingEntity.setImg(filePath);
        UserEntity user=userRepository.getById(speakingDto.getUserId());
        speakingEntity.setUser(user);
        speakingEntity.setContent(speakingDto.getContent());
        speakingRepository.save(speakingEntity);
        return "Thanh cong";
    }
    public SpeakingEntity findSpeakingById(int id) {
        Optional<SpeakingEntity> speaking = Optional.ofNullable(speakingRepository.findById(id));
        return speaking.orElse(null); // or handle as needed
    }
}
