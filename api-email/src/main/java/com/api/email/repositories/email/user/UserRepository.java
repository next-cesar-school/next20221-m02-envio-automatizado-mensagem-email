package com.api.email.repositories.email.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.email.models.email.user.UserModels;


@Repository
public interface UserRepository extends JpaRepository<UserModels, Long>  {
    
}




