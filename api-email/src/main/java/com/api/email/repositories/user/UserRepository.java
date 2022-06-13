package com.api.email.repositories.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.email.models.user.User;


public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByNameUser(String nameUser);
    boolean existsByEmailUser(String emailUser);

}
