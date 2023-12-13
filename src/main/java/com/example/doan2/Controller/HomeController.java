package com.example.doan2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ielts")
public class HomeController {
    @GetMapping("/home")
    public String home(Model model){
        return "/jsp/user/home.jsp";
    }
}
