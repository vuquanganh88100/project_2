package com.example.doan2.Service;

import com.example.doan2.Dto.AnswerReadingDto;
import com.example.doan2.Entities.AnswerReadingEntity;
import com.example.doan2.Entities.PassageEntity;
import com.example.doan2.Entities.UserEntity;
import com.example.doan2.Repository.AnswerReadingRepository;
import com.example.doan2.Repository.PassageRepository;
import com.example.doan2.Repository.ReadingQuestionRepository;
import com.example.doan2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class AnswerService {
@Autowired
    UserRepository userRepository;
@Autowired
    PassageRepository passageRepository;
@Autowired
    AnswerReadingRepository answerReadingRepository;

    public int checkAnswer(AnswerReadingDto answerReadingDto, Integer id, ReadingQuestionRepository questionRepository){
       List<String> correctAns=questionRepository.findCorrectAnswersByReadingId(id);
       int cnt=0;
       for(int i=0;i<correctAns.size();i++){
           if(answerReadingDto.getSelectedAns().get(i).equals(correctAns.get(i))){
               cnt++;
           }
       }
       return  cnt;

    }
    public double calculateScore(AnswerReadingDto answerReadingDto,Integer id,ReadingQuestionRepository readingQuestionRepository) {
        int cnt=checkAnswer(answerReadingDto,id,readingQuestionRepository);
        double bandScore=0;
        if (cnt >= 39 && cnt <= 40) {
            bandScore = 9.0;
        } else if (cnt >= 37 && cnt <= 38) {
            bandScore = 8.5;
        } else if (cnt >= 35 && cnt <= 36) {
            bandScore = 8.0;
        } else if (cnt >= 33 && cnt <= 34) {
            bandScore = 7.5;
        } else if (cnt >= 30 && cnt <= 32) {
            bandScore = 7.0;
        } else if (cnt >= 27 && cnt <= 29) {
            bandScore = 6.5;
        } else if (cnt >= 23 && cnt <= 26) {
            bandScore = 6.0;
        } else if (cnt >= 20 && cnt <= 22) {
            bandScore = 5.5;
        } else if (cnt >= 16 && cnt <= 19) {
            bandScore = 5.0;
        } else if (cnt >= 13 && cnt <= 15) {
            bandScore = 4.5;
        } else if (cnt >= 10 && cnt <= 12) {
            bandScore = 4.0;
        } else if (cnt >= 7 && cnt <= 9) {
            bandScore = 3.5;
        } else if (cnt >= 5 && cnt <= 6) {
            bandScore = 3.0;
        } else if (cnt >= 3 && cnt <= 4) {
            bandScore = 2.5;
        } else {
            bandScore = 0.0;
        }
    return  bandScore;
    }
    public String save(AnswerReadingDto answerReadingDto){
        AnswerReadingEntity answerReadingEntity=new AnswerReadingEntity();
        answerReadingEntity.setScore(answerReadingDto.getScore());
        UserEntity user=userRepository.getById(answerReadingDto.getUser_id());
        answerReadingEntity.setUser(user);
        PassageEntity passage=passageRepository.getById(answerReadingDto.getTest_id());
        answerReadingEntity.setPassageEntity(passage);
        answerReadingRepository.save(answerReadingEntity);
        return "Thanh cong";
    }

}


