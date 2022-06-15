package com.api.email.repositories.email;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.email.models.email.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>{  
}
