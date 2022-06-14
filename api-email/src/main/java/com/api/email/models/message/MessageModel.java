package com.api.email.models.message;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "MESSAGE_MODEL")
public class MessageModel implements Serializable { 
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long messageId;
    @Column (columnDefinition = "message_subject")
    private String messageSubject;
    @Column (columnDefinition = "message_text")
    private String messageText;

}

