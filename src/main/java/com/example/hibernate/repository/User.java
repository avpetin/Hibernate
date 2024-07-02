package com.example.hibernate.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class User implements Serializable {
    private String name;
    private String surname;
    private String age;
}
