package com.example.doan2.Controller.User.Answer;

import com.example.doan2.Dto.Answer.AnswerWritingDto;
import com.example.doan2.Dto.WritingDto;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.WritingEntity;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Service.Answer.WritingAnsService;
import com.example.doan2.Service.UserService;
import com.example.doan2.Service.WritingService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("ielts/writing")

public class Writing {
    @Autowired
    WritingService writingService;
    @Autowired
    WritingAnsService writingAnsService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/practice/exam{id}")
    public String getExam(Model model,
                          @PathVariable Integer id) {
        WritingEntity writingEntity = new WritingEntity();
        writingEntity = writingService.findWritingById(id);
        model.addAttribute("w", writingEntity);
        Integer userId=userService.findByUserEmail(userRepository);
        model.addAttribute("testId",id);
        model.addAttribute("userId",userId);
        return "/jsp/user/answer/writing.jsp";
    }

    @PostMapping("/save")
    public String save(Model model,
                       AnswerWritingDto answerWritingDto,
                       @RequestParam(value = "testId",required = false)Integer testId,
                       @RequestParam(value = "userId",required = false)Integer userId) {
        answerWritingDto.setUserId(userId);
        answerWritingDto.setTestId(testId);
        writingAnsService.save(answerWritingDto);
    return "Thanh cong";
    }
}
