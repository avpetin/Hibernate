package com.example.hibernate.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Getter
@Setter
public class Persons {
    @Id
    @GeneratedValue
    private int id;
    @EmbeddedId
    private User user;
    @Column(name = "phonenumber")
    private String phoneNumber;
    private String city;
}
