package com.example.doan2.Service.Answer;

import com.example.doan2.Dto.Answer.AnswerWritingDto;
import com.example.doan2.Dto.Answer.ScoringWritingDto;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.UserEntity;
import com.example.doan2.Entities.WritingEntity;
import com.example.doan2.Repository.AnswerWritingRepository;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Repository.WritingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service

public class WritingAnsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnswerWritingRepository answerWritingRepository;
    @Autowired
    WritingRepository writingRepository;
    public String save(AnswerWritingDto answerWritingDto){
        AnswerWritingEntity answerWritingEntity=new AnswerWritingEntity();
        answerWritingEntity.setScore(answerWritingDto.getScore());
        UserEntity user=userRepository.getById(answerWritingDto.getUserId());
        answerWritingEntity.setUser(user);
//        UserEntity marker=userRepository.getById(answerWritingDto.getMarkerId());
        answerWritingEntity.setMarker(null);
        WritingEntity writing=writingRepository.getById(answerWritingDto.getTestId());
        answerWritingEntity.setTest(writing);
        answerWritingEntity.setComment(answerWritingDto.getComment());
        answerWritingEntity.setTask1(answerWritingDto.getTask1());
        answerWritingEntity.setTask2(answerWritingDto.getTask2());
        answerWritingRepository.save(answerWritingEntity);
        return "THanh cong";
    }
    public List<AnswerWritingEntity> findResultsByAsker(Integer askerId) throws IOException {
        return writingRepository.findResultsByAsker(askerId);
    }
    public AnswerWritingEntity findById(Integer id){
        Optional<AnswerWritingEntity> optionalEntity = answerWritingRepository.findById(id);
        return optionalEntity.orElse(null); // or handle the absence of the entity as needed
    }
    public String score(ScoringWritingDto scoringWritingDto){
        AnswerWritingEntity answerWriting=answerWritingRepository.getById(scoringWritingDto.getAnsId());
        UserEntity user=userRepository.getById(scoringWritingDto.getMarkerId());
        answerWriting.setMarker(user);
        answerWriting.setComment(scoringWritingDto.getComment());
        answerWriting.setScore(scoringWritingDto.getScore());
        answerWritingRepository.save(answerWriting);
        return "thanh cong";
    }
}

