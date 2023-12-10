package com.example.doan2.Controller.User.Answer;

import com.example.doan2.Service.PassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ielts/reading")
public class Reading {
    @Autowired
    PassageService passageService;
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
            String output = passageService.generateOutputWithInputs(contents, types,nums,options);
            model.addAttribute("output" + passageNumber, output);
        }

        return "/jsp/user/answer/reading.jsp";
    }





}
