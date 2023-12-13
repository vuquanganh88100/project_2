package com.example.doan2.Controller;

import com.example.doan2.Dto.Answer.ScoringSpeakingDto;
import com.example.doan2.Dto.Answer.ScoringWritingDto;
import com.example.doan2.Dto.SpeakingDto;
import com.example.doan2.Entities.AnswerSpeakingEntity;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.SpeakingEntity;
import com.example.doan2.Entities.WritingEntity;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Service.Answer.SpeakingAnsService;
import com.example.doan2.Service.SpeakingService;
import com.example.doan2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("admin/speaking")
public class SpeakingController {
    @Autowired
    SpeakingService speakingService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SpeakingAnsService speakingAnsService;
    @GetMapping("/upload")
    public String save(Model model){
        Integer userId=userService.findByUserEmail(userRepository);
        model.addAttribute("userId",userId);
        return "/jsp/admin/speaking/upquestion.jsp";
    }
    @PostMapping("post")
    public String post(SpeakingDto speakingDto,
                       @RequestParam(value = "userId",required = false)Integer userId) throws IOException {
        speakingDto.setUserId(userId);
        speakingService.save(speakingDto);
        return "thanh cong";
    }
    @GetMapping("result/{id}")
    public String mark(Model model, Optional<AnswerSpeakingEntity> answerSpeaking,
                       SpeakingEntity speakingEntity,
                       @PathVariable Integer id
    ){
        answerSpeaking = Optional.ofNullable(speakingAnsService.findById(id));
        model.addAttribute("answer", answerSpeaking.orElse(null));
        int testId=answerSpeaking.get().getTest().getId();
        speakingEntity=speakingService.findSpeakingById(testId);
        model.addAttribute("s", speakingEntity);
        model.addAttribute("ansId",id);
        Integer userId=userService.findByUserEmail(userRepository);
        model.addAttribute("markerId",userId);

        return "/jsp/admin/speaking/mark.jsp";

    }
    @PostMapping("score")
    public String score(Model model, ScoringSpeakingDto scoringSpeakingDto,
                        @RequestParam(value = "ansId",required = false) Integer ansId,
                        @RequestParam(value = "markerId",required = false) Integer markerId){
        scoringSpeakingDto.setMarkerId(markerId);
        scoringSpeakingDto.setAnsId(ansId);
        speakingAnsService.score(scoringSpeakingDto);
        return "thanh cong";
    }
}
