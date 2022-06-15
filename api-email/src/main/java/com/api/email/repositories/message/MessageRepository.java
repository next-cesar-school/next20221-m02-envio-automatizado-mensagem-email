package com.api.email.repositories.message;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.email.models.message.MessageModel;

public interface MessageRepository extends JpaRepository<MessageModel, Long> {
    
}
