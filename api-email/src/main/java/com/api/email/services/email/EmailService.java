package com.api.email.services.email;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.api.email.enums.email.StatusEmail;
import com.api.email.models.email.EmailModel;
import com.api.email.models.message.MessageModel;
import com.api.email.models.user.User;
import com.api.email.repositories.email.EmailRepository;
import com.api.email.repositories.message.MessageRepository;
import com.api.email.repositories.user.UserRepository;


@Service
public class EmailService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;


    public EmailModel sendEmailUser(EmailModel emailModel, User user){
        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(user.getEmailUser());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
            emailModel.setEmailTo(user.getEmailUser());
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally{
            return emailRepository.save(emailModel);
        }
    }

    public EmailModel sendEmailUserSubject(EmailModel emailModel, User user, MessageModel messageModel){
        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(user.getEmailUser());
            message.setSubject(messageModel.getMessageSubject());
            message.setText(messageModel.getMessageText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
            emailModel.setEmailTo(user.getEmailUser());
            emailModel.setSubject(messageModel.getMessageSubject());
            emailModel.setText(messageModel.getMessageText());
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally{
            return emailRepository.save(emailModel);
        }
    }
}
