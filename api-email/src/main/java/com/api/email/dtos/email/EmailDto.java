package com.api.email.dtos.email;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {
    
    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String emailFrom;
    @Email
    private String emailTo;
    
    private String subject;
    
    private String text;
}
