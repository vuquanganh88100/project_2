package com.example.doan2.Controller;

import com.example.doan2.Dto.TokenDto;
import com.example.doan2.Dto.UserDto;
import com.example.doan2.Config.UserDetailServiceImp;
import com.example.doan2.Dto.TokenDto;
import com.example.doan2.Dto.UserDto;
import com.example.doan2.Entities.ConfirmTokenEntity;
import com.example.doan2.Service.EmailService;
import com.example.doan2.Service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ielts")
public class SignUpController {
    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;

    @Autowired
    private UserDetailServiceImp userDetailServiceImp;

    @GetMapping("/signup")
    public String signup(){
        return "/jsp/user/signup.jsp";
    }
    @PostMapping(value = "/signup/save")
    public String save(UserDto userDto ) throws MessagingException {

        userService.save(userDto);

        return "thanh cong";
    }
//    public String save(UserDto userDto ) throws MessagingException {
//
//        userService.save(userDto);
//        return "thanh cong";
//    }
    @GetMapping("/confirm-account")
    public String verifyAccount(@RequestParam("token") String confirmationToken){
        ConfirmTokenEntity tokenEntity = new ConfirmTokenEntity();
        tokenEntity.setConfirmToken(confirmationToken);
        if(userService.verify(tokenEntity)) {
            return "/jsp/user/confirmSignup.jsp";
        }else{
            return "khong thanh cong";
        }
    }
    @GetMapping("/login")
    public String login(){
        return "/jsp/user/login.jsp";
    }
}
