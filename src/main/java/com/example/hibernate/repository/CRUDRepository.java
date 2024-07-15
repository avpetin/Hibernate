package com.example.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository extends JpaRepository<Persons, Integer> {
    List<Persons> findPersonsByUserAgeLessThanOrderByUserAge(int age);

    Optional<Persons> findPersonsByUserNameAndUserSurname(String name, String surname);
}
