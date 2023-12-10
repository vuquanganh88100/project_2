package com.example.doan2.Service;

import com.example.doan2.Dto.TokenDto;
import com.example.doan2.Dto.UserDto;
import jakarta.mail.MessagingException;

public interface SendingEmail {
    String sendSimpleMail(UserDto userDto,TokenDto tokenDto ) throws MessagingException;

}
