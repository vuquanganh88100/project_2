package com.example.doan2.Controller.User.Answer;

import com.example.doan2.Controller.WritingController;
import com.example.doan2.Entities.AnswerReadingEntity;
import com.example.doan2.Entities.AnswerWritingEntity;
import com.example.doan2.Entities.WritingEntity;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Service.Answer.ResultService;
import com.example.doan2.Service.UserService;
import com.example.doan2.Service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("ielts")
public class ResultController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ResultService resultService;
    @Autowired
    WritingService writingService;
    @Autowired
    WritingController writingController;
    @Autowired
    Reading reading;

    @GetMapping("/result")
    public String getResult( Model model) {
        Integer userId = userService.findByUserEmail(userRepository);
        List<AnswerWritingEntity> answerWritingEntities = resultService.resultWriting(userId);
        model.addAttribute("writing", answerWritingEntities);
        List<AnswerReadingEntity> answerReadingEntities = resultService.resulReading(userId);
        model.addAttribute("reading", answerReadingEntities);
        return "/jsp/user/answer/result.jsp";
    }
    @GetMapping("/result/writing/{id}")
    public String getWritingExam(Model model,@PathVariable Integer id,
                                 Optional<AnswerWritingEntity> answerWritingEntity,
                                 WritingEntity writingEntity){
        writingController.mark(model,answerWritingEntity,writingEntity,id);
        // lấy data sau khi chấm bài từ contrller admin
        return "/jsp/admin/writing/mark.jsp";
    }
    @GetMapping("/result/reading/{id}")
    public String getReadingExam(@PathVariable Integer id,Model model){
        reading.getExam(id,model);
        return "/jsp/admin/reading/result.jsp";

    }

}
