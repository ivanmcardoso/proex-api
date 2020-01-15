package com.gear.proex.service.impl;

import com.gear.proex.model.User;
import com.gear.proex.repository.UserRepository;
import com.gear.proex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
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
