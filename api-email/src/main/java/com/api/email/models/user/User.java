package com.api.email.models.user;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name ="TB_USER")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idUser;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "email_user")
    private String emailUser;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

}
