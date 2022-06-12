package com.api.email.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.email.models.user.User;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNameUser(String nameUser);
    boolean existsByEmailUser(String emailUser);

}
