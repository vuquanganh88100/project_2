package com.example.doan2.Service;

import com.example.doan2.Dto.TokenDto;
import com.example.doan2.Dto.UserDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements  SendingEmail{
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendSimpleMail(UserDto userDto, TokenDto tokenDto) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("Complete Registration!");
        mimeMessageHelper.setFrom("cvachemistry002@gmail.com");
        mimeMessageHelper.setTo(userDto.getUserEmail());
        mimeMessageHelper.setText("To confirm your account, please click here : "
                +"http://localhost:8082/confirm-account?token="+tokenDto.getConfirmToken());
        javaMailSender.send(mimeMessage);
        return "send thanh cong";
    }



}
