package com.example.doan2.Service;

import com.example.doan2.Dto.TokenDto;
import com.example.doan2.Dto.UserDto;
import com.example.doan2.Entities.ConfirmTokenEntity;
import jakarta.mail.MessagingException;

public interface SendingEmail {
    String sendSimpleMail(UserDto userDto, ConfirmTokenEntity token) throws MessagingException;

}