package com.example.doan2.Controller;

import com.example.doan2.Dto.Answer.AnswerWritingDto;
import com.example.doan2.Dto.Answer.ScoringWritingDto;
import com.example.doan2.Dto.WritingDto;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.WritingEntity;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Service.Answer.WritingAnsService;
import com.example.doan2.Service.UserService;
import com.example.doan2.Service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/writing")
public class WritingController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WritingService writingService;
    @Autowired
    WritingAnsService writingAnsService;
    @GetMapping("upload")
    public String upload(Model model){
        Integer userId=userService.findByUserEmail(userRepository);
        model.addAttribute("userId",userId);

 return "/jsp/admin/writing/upquestion.jsp";
    }

        @PostMapping("save")
    public String save(WritingDto writingDto,
                       @RequestParam(value = "userId",required = false)Integer userId) throws IOException {
        writingDto.setUserId(userId);
        writingService.save(writingDto);
        return "Thanh cong";
    }
    @GetMapping("/result")
    public String listAns(Model model) throws IOException {
        Integer userId=userService.findByUserEmail(userRepository);
        model.addAttribute("markerId",userId);

        AnswerWritingEntity answerWriting=new AnswerWritingEntity();
        List<AnswerWritingEntity> answerWritingList = writingAnsService.findResultsByAsker(userId);
        model.addAttribute("anStudent",answerWritingList);

        return "/jsp/admin/writing/listAns.jsp";

    }
    @GetMapping("result/{id}")
    public String mark(Model model, Optional<AnswerWritingEntity> answerWritingEntity,
                       WritingEntity writingEntity,
                       @PathVariable Integer id
                       ){
        answerWritingEntity = Optional.ofNullable(writingAnsService.findById(id));
        model.addAttribute("answer", answerWritingEntity.orElse(null));
        int wordCountTemp1 = countWords(answerWritingEntity.get().getTask1());
        int wordCountTemp2 = countWords(answerWritingEntity.get().getTask2());
        model.addAttribute("cnt1",wordCountTemp1);
        model.addAttribute("cnt2",wordCountTemp2);
        int testId=answerWritingEntity.get().getTest().getId();
        writingEntity=writingService.findWritingById(testId);
        model.addAttribute("w", writingEntity);
        model.addAttribute("ansId",id);
        Integer userId=userService.findByUserEmail(userRepository);
        model.addAttribute("markerId",userId);

        return "/jsp/admin/writing/mark.jsp";

    }
    public int countWords(String text) {
        // \\s+ sử dụng cho nhiều khoảng trắng
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
    @PostMapping("score")
    public String score(Model model, ScoringWritingDto scoringWritingDto,
                        @RequestParam(value = "ansId",required = false) Integer ansId,
                        @RequestParam(value = "markerId",required = false) Integer markerId){
        scoringWritingDto.setMarkerId(markerId);
        scoringWritingDto.setAnsId(ansId);
        writingAnsService.score(scoringWritingDto);
        return "thanh cong";
    }
}
