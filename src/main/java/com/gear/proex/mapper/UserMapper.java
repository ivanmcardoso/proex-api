package com.gear.proex.mapper;

import com.gear.proex.DTO.UserDTO;
import com.gear.proex.model.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    public UserDTO convertToDTO(User user){
            return new ModelMapper().map(user,UserDTO.class);
    }
}
