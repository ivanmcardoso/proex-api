package com.gear.proex.DTO;


import com.gear.proex.enums.ProfileEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class UserRegisterDTO {

    @NotEmpty(message = "name should not be empty")
    @Length(min = 3, max = 100, message = "name must be between 3 and 100 characters")
    private String name;

    @NotEmpty(message = "username should not be empty")
    @Length(min = 3, max = 100, message = "username must be between 3 and 100 characters")
    private String userName;

    @NotEmpty(message = "email should not be empty")
    @Length(min = 3, max = 100, message = "email must be between 3 and 100 characters")
    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "password should not be empty")
    private String password;

    private boolean isAdmin;

}
