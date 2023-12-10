package com.example.doan2.Service;

import com.example.doan2.Dto.TokenDto;
import com.example.doan2.Dto.UserDto;
import com.example.doan2.Entities.ConfirmTokenEntity;
import com.example.doan2.Entities.UserEntity;
import com.example.doan2.Repository.ConfirmTokenRepository;
import com.example.doan2.Repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;
    @Autowired
    ConfirmTokenRepository confirmTokenRepository;

    public String save(UserDto userDto, TokenDto tokenDto) throws MessagingException {
        UserEntity userEntity =new UserEntity();
        userEntity.setUserEmail(userDto.getUserEmail());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
        userEntity.setUserRole(userDto.getUserRole());
        userEntity.setUserEnable(false);
        userRepository.save(userEntity);
        emailService.sendSimpleMail(userDto,tokenDto);
        verify(tokenDto);
        return "Tao moi tai khoan thanh cong ";
    }
    public void verify(TokenDto token){
        ConfirmTokenEntity tokenEntity=confirmTokenRepository.findByConfirmToken(token.getConfirmToken());
    if(tokenEntity!=null){
        UserEntity userEntity=userRepository.findByUserEmailIgnoreCase(tokenEntity.getUserEntity().getUserEmail());
        userEntity.setUserEnable(true);
    }
    }
}
