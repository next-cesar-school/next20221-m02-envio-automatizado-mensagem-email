package com.api.email.dtos.message;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MessageDto {

  @NotBlank
  private String messageSubject;
  @NotBlank
  private String messageText;

}