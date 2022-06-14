package com.api.email.dtos.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserDto {    

    @NotBlank
    private String nameUser;
    
    @NotBlank
    @Email
    private String emailUser;
}
