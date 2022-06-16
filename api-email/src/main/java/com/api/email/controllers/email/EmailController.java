package com.api.email.controllers.email;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.email.dtos.email.EmailDto;
import com.api.email.models.email.EmailModel;
import com.api.email.models.message.MessageModel;
import com.api.email.models.user.User;
import com.api.email.services.email.EmailService;
import com.api.email.services.message.MessageService;
import com.api.email.services.user.UserService;

@RestController
public class EmailController {

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;
    
    @Autowired
    EmailService emailService; 

    @PostMapping("/sending-email/{nameUser}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "nameUser") String nameUser, 
    @RequestBody @Valid EmailDto emailDto){
        Optional<User> userOptional = userService.findByNameUser(nameUser);
        if(!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmailUser(emailModel, userOptional.get());
        return new ResponseEntity<Object>(emailModel, HttpStatus.CREATED);
    }



    @PostMapping("/sending-email/{nameUser}/{messageSubject}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "nameUser") String nameUser, 
    @PathVariable(value = "messageSubject") String messageSubject,  @RequestBody @Valid EmailDto emailDto){
        Optional<User> userOptional = userService.findByNameUser(nameUser);
        Optional<MessageModel> messageOptional = messageService.findByMessageSubject(messageSubject);
        if(!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        if(!messageOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subject not found.");
        }

        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmailUserSubject(emailModel, userOptional.get(), messageOptional.get());
        return new ResponseEntity<Object>(emailModel, HttpStatus.CREATED);
    }

}
