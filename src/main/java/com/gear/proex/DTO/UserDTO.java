package com.gear.proex.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotEmpty(message = "name should not be empty")
    private String name;

    @NotEmpty(message = "name should not be empty")
    private String username;

    @NotEmpty(message = "name should not be empty")
    private String email;
}
