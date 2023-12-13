package com.example.doan2.Service.Answer;

import com.example.doan2.Dto.Answer.AnswerSpeakingDto;
import com.example.doan2.Dto.Answer.AnswerWritingDto;
import com.example.doan2.Dto.Answer.ScoringSpeakingDto;
import com.example.doan2.Dto.Answer.ScoringWritingDto;
import com.example.doan2.Entities.AnswerSpeakingEntity;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.SpeakingEntity;
import com.example.doan2.Entities.UserEntity;
import com.example.doan2.Repository.AnswerSpeakingRepository;
import com.example.doan2.Repository.SpeakingRepository;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SpeakingAnsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SpeakingRepository speakingRepository;
    @Autowired
    AnswerSpeakingRepository answerSpeakingRepository;

    public String save(AnswerSpeakingDto answerSpeakingDto) throws IOException {
        AnswerSpeakingEntity answerSpeaking=new AnswerSpeakingEntity();
        answerSpeaking.setScore(null);
        answerSpeaking.setComment(answerSpeakingDto.getComment());
        String filePath=String.valueOf(FileUtils.saveAudioFileFromMultiPartFile(answerSpeakingDto.getAudioFile()));
        answerSpeaking.setAudio(filePath);
        UserEntity user=userRepository.getById(answerSpeakingDto.getUserId());
        answerSpeaking.setUser(user);
//        UserEntity marker=userRepository.getById(answerSpeakingDto.getMarkerId());
        answerSpeaking.setMarker(null);
        SpeakingEntity speaking =speakingRepository.getById(answerSpeakingDto.getTestId());
        answerSpeaking.setTest(speaking);
        answerSpeakingRepository.save(answerSpeaking);
        return "thanh cong";
    }
    public List<AnswerSpeakingEntity> findResultsByAsker(Integer askerId) throws IOException {
        return speakingRepository.findResultsByAsker(askerId);
    }
    public AnswerSpeakingEntity findById(Integer id){
        Optional<AnswerSpeakingEntity> answerSpeaking = answerSpeakingRepository.findById(id);
        return answerSpeaking.orElse(null); // or handle the absence of the entity as needed
    }
    public String score(ScoringSpeakingDto scoringSpeakingDto){
       AnswerSpeakingEntity answerSpeaking=answerSpeakingRepository.getReferenceById(scoringSpeakingDto.getAnsId());
       UserEntity user=userRepository.getById(scoringSpeakingDto.getMarkerId());
       answerSpeaking.setScore(scoringSpeakingDto.getScore());
       answerSpeaking.setComment(scoringSpeakingDto.getComment());
       answerSpeaking.setMarker(user);
       answerSpeakingRepository.save(answerSpeaking);
        return "thanh cong";
    }


}
