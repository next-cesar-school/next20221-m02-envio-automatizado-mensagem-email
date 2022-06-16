package com.api.email.repositories.message;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.email.models.message.MessageModel;

public interface MessageRepository extends JpaRepository<MessageModel, Long> {

    Optional<MessageModel> findByMessageSubject(String messageSubject);

}
