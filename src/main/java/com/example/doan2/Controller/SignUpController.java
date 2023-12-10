package com.example.doan2.Controller;

import com.example.doan2.Dto.TokenDto;
import com.example.doan2.Dto.UserDto;
import com.example.doan2.Service.EmailService;
import com.example.doan2.Service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ielts")
public class SignUpController {
    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;
    @GetMapping("/signup")
    public String signup(){
        return "/jsp/user/signup.jsp";
    }
    @PostMapping(value = "/signup/save")
    public String save(UserDto userDto , TokenDto tokenDto) throws MessagingException {

        userService.save(userDto,tokenDto);
        return "thanh cong";
    }
}
