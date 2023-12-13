package com.example.doan2.Service.Answer;

import com.example.doan2.Entities.AnswerReadingEntity;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Repository.AnswerReadingRepository;
import com.example.doan2.Repository.AnswerWritingRepository;
import com.example.doan2.Repository.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    AnswerWritingRepository answerWritingRepository;
    @Autowired
    AnswerReadingRepository answerReadingRepository;

    public List<AnswerWritingEntity> resultWriting(Integer userId
                         ){
        List<AnswerWritingEntity>answerWritingEntities=new ArrayList<>();
        answerWritingEntities=answerWritingRepository.findResultsByUserId(userId);
        return  answerWritingEntities;
    }
    public List<AnswerReadingEntity> resulReading(Integer userId
    ){
        List<AnswerReadingEntity> answerReadingEntities=new ArrayList<>();
        answerReadingEntities=answerReadingRepository.findResultsByUserId(userId);
        return answerReadingEntities;
    }
}
