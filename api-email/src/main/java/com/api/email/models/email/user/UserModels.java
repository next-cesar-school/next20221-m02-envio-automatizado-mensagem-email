package com.api.email.models.email.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table  (name = "TB_USER")

public class UserModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser;
    @Column
    private String nomeUser;
    @Column
    private String emailUser;
}



