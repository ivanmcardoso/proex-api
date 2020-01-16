package com.gear.proex.controller;

import com.gear.proex.model.User;
import com.gear.proex.repository.UserRepository;
import com.gear.proex.security.AccountCredentialsVO;
import com.gear.proex.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/singin")
    public ResponseEntity singin(@RequestBody AccountCredentialsVO data){
        try {
            String username = data.getUsername();
            String password = data.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

            User user = userRepository.findByUserName(username);

            String token = "";
            if (user != null) {
                token = tokenProvider.createToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("UserName:"+username+" Not Found");
            }
            Map<String, String> model = new HashMap<>();
            model.put("username",username);
            model.put("token",token);
            return ResponseEntity.ok(model);
        } catch (Exception e){
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
