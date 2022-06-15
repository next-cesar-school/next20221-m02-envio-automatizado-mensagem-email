package com.api.email.repositories.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.email.models.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByNameUser(String nameUser);
    boolean existsByNameUser(String nameUser);
    boolean existsByEmailUser(String emailUser);

}
