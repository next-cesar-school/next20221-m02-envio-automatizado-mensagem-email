package com.api.email.controllers.user;


import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.email.dtos.user.UserDto;
import com.api.email.models.user.User;
import com.api.email.services.user.UserService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){
        if(userService.existsByNameUser(userDto.getNameUser())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Username already registered.");
        }
        if(userService.existsByEmailUser(userDto.getEmailUser())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: E-mail already registered.");
        }

        var user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") Long idUser){
        Optional<User> userOptional = userService.findById(idUser);
        if (!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long idUser){
        Optional<User> userOptional = userService.findById(idUser);
        if(!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        userService.delete(userOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long idUser, @RequestBody @Valid UserDto userDto){
        Optional<User> userOptional = userService.findById(idUser);
        if(!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var user = userOptional.get();
        user.setNameUser(userDto.getNameUser());
        user.setEmailUser(userDto.getEmailUser());

        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));

    }

}