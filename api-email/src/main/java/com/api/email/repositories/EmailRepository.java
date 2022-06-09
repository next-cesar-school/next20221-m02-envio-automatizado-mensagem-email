package com.api.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>{  
}
