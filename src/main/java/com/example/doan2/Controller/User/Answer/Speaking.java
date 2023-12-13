package com.example.doan2.Controller.User.Answer;

import com.example.doan2.Dto.Answer.AnswerSpeakingDto;
import com.example.doan2.Dto.Answer.AnswerWritingDto;
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

@Controller
@RequestMapping("ielts/speaking")
public class Speaking {

    @Autowired
    SpeakingService speakingService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SpeakingAnsService speakingAnsService;

    @GetMapping("practice/exam{id}")
    public String getExam(Model model,
                          @PathVariable Integer id) {
        SpeakingEntity speakingEntity = new SpeakingEntity();
        speakingEntity = speakingService.findSpeakingById(id);
        model.addAttribute("s", speakingEntity);
        Integer userId = userService.findByUserEmail(userRepository);
        model.addAttribute("testId", id);
        model.addAttribute("userId", userId);
        return "/jsp/user/answer/speaking.jsp";
    }

    @PostMapping("save")
    public String save(Model model,
                       AnswerSpeakingDto answerSpeakingDto,
                       @RequestParam(value = "testId", required = false) Integer testId,
                       @RequestParam(value = "userId", required = false) Integer userId) throws IOException {
        answerSpeakingDto.setUserId(userId);
        answerSpeakingDto.setTestId(testId);
        speakingAnsService.save(answerSpeakingDto);
        return "Thanh cong";
    }
}

