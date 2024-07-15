package com.example.hibernate.repository;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Persons", schema = "netology")
public class Persons {
    @Id
    @GeneratedValue
    private int id;
    @Embedded
    private User user;
    @Column(name = "phonenumber")
    private String phoneNumber;
    private String city;
}
