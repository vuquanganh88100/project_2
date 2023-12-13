package com.example.doan2.Controller.User.Answer;

import com.example.doan2.Dto.Answer.AnswerReadingDto;
import com.example.doan2.Repository.ReadingQuestionRepository;
import com.example.doan2.Repository.UserRepository;
import com.example.doan2.Service.AnswerService;
import com.example.doan2.Service.PassageService;
import com.example.doan2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("ielts/reading")
public class Reading {
    @Autowired
    PassageService passageService;
    @Autowired
    UserService userService;
    @Autowired
    AnswerService answerService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReadingQuestionRepository questionRepository;
    int userId;
    public void findAllPassageInfo(Integer id, Model model) {
        for (int passageNumber = 1; passageNumber <= 3; passageNumber++) {
            List<String> contents = passageService.findContentByPassage(id, passageNumber);
            List<String> types = passageService.findTypeByPassage(id, passageNumber);
            String passage = passageService.passage(id, passageNumber);
            String[][] options=passageService.option(id,passageNumber);
            passage = passage.replace("\n", "<br>");
            List<Integer>nums=passageService.findNumber(id,passageNumber);
            model.addAttribute("options"+passageNumber,options);
            model.addAttribute("nums"+passageNumber,nums);
            model.addAttribute("contents" + passageNumber, contents);
            model.addAttribute("types" + passageNumber, types);
            model.addAttribute("passage" + passageNumber, Collections.singletonList(passage));
        }
    }
    @GetMapping("/practice/exam/{id}")
    public String getExam(@PathVariable Integer id, Model model) {
        findAllPassageInfo(id, model);

        for (int passageNumber = 1; passageNumber <= 3; passageNumber++) {
            List<Integer> nums = (List<Integer>) model.getAttribute("nums" + passageNumber);
            String[][]options= (String[][]) model.getAttribute("options"+passageNumber);
            List<String> contents = (List<String>) model.getAttribute("contents" + passageNumber);
            List<String> types = (List<String>) model.getAttribute("types" + passageNumber);
            String output = passageService.generateOutputWithInputs(contents, types,nums,options,passageNumber);
            model.addAttribute("output" + passageNumber, output);
        }
        model.addAttribute("userId",userId);
        model.addAttribute("examId",id);
        userId=userService.findByUserEmail(userRepository);

        return "/jsp/user/answer/reading.jsp";
    }

@PostMapping(value = "submit", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public ResponseEntity<String> submitReadingAnswers(@RequestParam Map<String, String> formData,AnswerReadingDto answerReadingDto,
                                                   @RequestParam("test_id") Integer examID,
                                                   @RequestParam(value = "userId",required = false)Integer userId) {
    List<String> selectedAnswers = new ArrayList<>();
    System.out.println(formData.size());
    for (Map.Entry<String, String> entry : formData.entrySet()) {
        String key = entry.getKey();
        if (key.startsWith("input_") && !key.endsWith("_placeholder")) {
            String values = entry.getValue();
            selectedAnswers.addAll(Collections.singleton(values));
        }else if(key.endsWith("_placeholder")){
            String originalString = entry.getKey();
            String cutString="";
            int placeholderIndex = originalString.lastIndexOf("_placeholder");
                cutString = originalString.substring(0, placeholderIndex);
                if(!formData.containsKey(cutString)){
                    selectedAnswers.add(" ");
                }

        }
    }
answerReadingDto.setSelectedAns(selectedAnswers);
//    System.out.println(userId);
//    System.out.println(examID);
    answerReadingDto.setUser_id(userId);
    answerReadingDto.setTest_id(examID);
    answerReadingDto.setScore(answerService.calculateScore(answerReadingDto,examID,questionRepository));
    answerService.save(answerReadingDto);
    System.out.println(answerReadingDto.getScore());
// truyền userID từ jsp nữa
    for(int i=0;i<selectedAnswers.size();i++){
        System.out.println("Cau hoi"+(i+1)+selectedAnswers.get(i));
    }

    return ResponseEntity.ok("Answers submitted successfully");
}







}
