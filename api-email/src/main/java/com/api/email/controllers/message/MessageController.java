package com.api.email.controllers.message;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import com.api.email.dtos.message.MessageDto;
import com.api.email.models.message.MessageModel;
import com.api.email.services.message.MessageService;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/message")
public class MessageController {

  final MessageService messageService;

  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @PostMapping
  public ResponseEntity<Object> saveMessageModel(@RequestBody @Valid MessageDto messageDto) {

    var messageModel = new MessageModel();
    BeanUtils.copyProperties(messageDto, messageModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(messageService.save(messageModel));
  }


  @GetMapping
  public ResponseEntity<List<MessageModel>> getAllMessageModels() {
    return ResponseEntity.status(HttpStatus.OK).body(messageService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getOneMessageModel(@PathVariable(value = "id") Long messageId) {
    Optional<MessageModel> messageOptional = messageService.findById(messageId);
    if (!messageOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message not found.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(messageOptional.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteMessageModel(@PathVariable(value = "id") Long messageId) {
    Optional<MessageModel> messageOptional = messageService.findById(messageId);
    if (!messageOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message not found.");
    }
    messageService.delete(messageOptional.get());
    return ResponseEntity.status(HttpStatus.OK).body("Message deleted successfully.");
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateMessageModel(@PathVariable(value = "id") Long messageId, @RequestBody @Valid MessageDto MessageDto){
    Optional<MessageModel> messageOptional = messageService.findById(messageId);
    if (!messageOptional.isPresent()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message not found.");
    }
    var messageModel = messageOptional.get();
    messageModel.setMessageSubject(MessageDto.getMessageSubject());
    messageModel.setMessageText(MessageDto.getMessageText());

    return ResponseEntity.status(HttpStatus.OK).body(messageService.save(messageModel));
  }
}
