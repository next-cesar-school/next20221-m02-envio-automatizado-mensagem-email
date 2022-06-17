package com.api.email.services.user;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.email.models.user.User;
import com.api.email.repositories.user.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user) ;
    }

    public boolean existsByNameUser(String nameUser) {
        return userRepository.existsByNameUser(nameUser);
    }

    public boolean existsByEmailUser(String emailUser) {
        return userRepository.existsByEmailUser(emailUser);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByNameUser(String nameUser) {
        return userRepository.findByNameUser(nameUser);
    }

    public Optional<User> findById(Long idUser) {
        return userRepository.findById(idUser);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

}
