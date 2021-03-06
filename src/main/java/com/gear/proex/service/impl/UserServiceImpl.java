package com.gear.proex.service.impl;

import com.gear.proex.DTO.UserDTO;
import com.gear.proex.mapper.UserMapper;
import com.gear.proex.model.User;
import com.gear.proex.repository.UserRepository;
import com.gear.proex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        List<User> userList =  userRepository.findAll();
        return userList.stream().map(user -> new UserMapper().convertToDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.ofNullable(userRepository.findByUserName(userName));
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
