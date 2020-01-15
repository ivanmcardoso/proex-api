package com.gear.proex.service;

import com.gear.proex.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    Optional<User> findByUserName(String userName);

    User save(User user);

    void delete(Long id);
}
