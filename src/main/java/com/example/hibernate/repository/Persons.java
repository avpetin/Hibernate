package com.example.hibernate.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Persons {
    @EmbeddedId
    private User user;
    private String phoneNumber;
    private String city;
}
