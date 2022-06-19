package com.api.email.dtos.email;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class EmailDto {
    
    @Email
    private String emailTo;
    
    private String subject;
    
    private String text;
}
