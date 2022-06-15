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
import com.api.email.models.user.User;
import com.api.email.services.email.EmailService;
import com.api.email.services.user.UserService;

@RestController
public class EmailController {

    @Autowired
    UserService userService;
    
    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<EmailModel>(emailModel, HttpStatus.CREATED);
    }

    @PostMapping("/sending-email/{nameUser}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "nameUser") String nameUser, @RequestBody @Valid EmailDto emailDto){
        Optional<User> userOptional = userService.findByNameUser(nameUser);
        if(!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmailUser(emailModel, userOptional.get());
        return new ResponseEntity<Object>(emailModel, HttpStatus.CREATED);
    }

}
