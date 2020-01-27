package com.gear.proex.controller;

import com.gear.proex.DTO.UserDTO;
import com.gear.proex.DTO.UserRegisterDTO;
import com.gear.proex.enums.ProfileEnum;
import com.gear.proex.model.Permission;
import com.gear.proex.model.User;
import com.gear.proex.service.UserService;
import com.gear.proex.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserRegisterDTO>  register( @Valid @RequestBody UserRegisterDTO userRegisterDTO){

        try{
            User user = convertTo(userRegisterDTO);
            userService.save(user);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(userRegisterDTO);
        }

        return ResponseEntity.ok(userRegisterDTO);
    }

    @GetMapping
    public List<UserDTO> getAll(){
        return userService.getAll();
    }

    @DeleteMapping
    public void deleteById(Long id){
        userService.delete(id);
    }

    @GetMapping("/findByUserName")
    public Optional<User> findByUserName(String userName){
        return userService.findByUserName(userName);
    }

    public User convertTo(UserRegisterDTO userRegisterDTO){
        User user = new User();
        user.setName(userRegisterDTO.getName());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(PasswordUtils.gerarBCrypt(userRegisterDTO.getPassword()));
        user.setUserName(userRegisterDTO.getUserName());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        return user;
    }
}
