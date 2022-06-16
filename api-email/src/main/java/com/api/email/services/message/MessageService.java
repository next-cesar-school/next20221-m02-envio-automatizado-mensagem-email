package com.api.email.services.message;

import org.springframework.stereotype.Service;
import com.api.email.repositories.message.MessageRepository;
import com.api.email.models.message.MessageModel;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

  final MessageRepository messageRepository;

  public MessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Transactional
  public MessageModel save(MessageModel messageModel) {
    return messageRepository.save(messageModel);
  }

  public List<MessageModel> findAll() {
    return messageRepository.findAll();
  }

  public Optional<MessageModel> findById(Long messageId) {
    return messageRepository.findById(messageId);

  }

  @Transactional
  public void delete(MessageModel messageModel) {
    messageRepository.delete(messageModel);
  }

  public Optional<MessageModel> findByMessageSubject(String messageSubject) {
    return messageRepository.findByMessageSubject(messageSubject);
  }
}
