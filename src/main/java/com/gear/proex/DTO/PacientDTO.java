package com.gear.proex.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PacientDTO {

    private  Long id;

    @NotEmpty(message = "name should not be empty")
    @Length(min = 3, max = 100, message = "name must be between 3 and 100 characters")
    private String name;

    private Long age;

    @NotEmpty(message = "name should not be empty")
    @CPF
    private String cpf;
}
