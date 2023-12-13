package com.example.doan2.Service;

import com.example.doan2.Dto.UserDto;
import com.example.doan2.Entities.ConfirmTokenEntity;
import com.example.doan2.Entities.UserEntity;
import com.example.doan2.Repository.ConfirmTokenRepository;
import com.example.doan2.Repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String save(UserDto userDto) throws MessagingException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserEmail(userDto.getUserEmail());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
        userEntity.setUserRole(userDto.getUserRole());
        userEntity.setUserEnable(false);
        userRepository.save(userEntity);
        ConfirmTokenEntity confirmTokenEntity = new ConfirmTokenEntity(userEntity); // Initialize confirmDate and confirmToken in the constructor
        confirmTokenRepository.save(confirmTokenEntity);
        emailService.sendSimpleMail(userDto, confirmTokenEntity);
        return "Tao moi tai khoan thanh cong ";
    }

    public boolean verify(ConfirmTokenEntity token) {
        ConfirmTokenEntity tokenEntity = confirmTokenRepository.findByConfirmToken(token.getConfirmToken());
        if (tokenEntity != null) {
            UserEntity userEntity = userRepository.findByUserEmailIgnoreCase(tokenEntity.getUserEntity().getUserEmail());
            userEntity.setUserEnable(true);
            userRepository.save(userEntity);
            return true;
        } else {
            return false;
        }
    }

    public String getCurrentId() {
        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
            System.out.println(currentUserName);
        }
        return currentUserName;
    }
    public Integer findByUserEmail(UserRepository userRepository) {
        String userEmail = getCurrentId();
        Integer userId = userRepository.findUserIdByUserEmailIgnoreCase(userEmail);

        if (userId != null) {
            int id = userId.intValue();
            System.out.println(id);
            return id;
        } else {
            // Handle the case when the user ID is not found for the given email
            return null; // Or handle it accordingly based on your application logic
        }
    }

}