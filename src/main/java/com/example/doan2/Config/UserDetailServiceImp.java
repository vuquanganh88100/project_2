package com.example.doan2.Config;
import com.example.doan2.Entities.UserEntity;
import com.example.doan2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
// lâ thông tin user từ db
public class  UserDetailServiceImp implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Model model = new ExtendedModelMap();

        UserEntity userEntity = userRepository.findByUserEmailIgnoreCase(userEmail);
        if (userEntity == null) {
            model.addAttribute("errorMessage", "User not found");

            throw new UsernameNotFoundException("notfound");
        } else if (!userEntity.isUserEnable()) {
            model.addAttribute("errorMessage", "User not active");

            throw new UsernameNotFoundException("notverified");
        }

        List<GrantedAuthority> setAuths=new ArrayList<>();
        setAuths.add(new SimpleGrantedAuthority("ROLE_"+userEntity.getUserRole()));


        User user =new User(userEntity.getUserEmail(),userEntity.getUserPassword(),setAuths);
        return  user;
    }
}
