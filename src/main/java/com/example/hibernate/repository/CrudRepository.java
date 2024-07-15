package com.example.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudRepository extends JpaRepository<Persons, Integer> {
    List<Persons> findPersonsByUserAgeLessThanOrderByUserAge(int age);

    Optional<Persons> findPersonsByUserNameAndUserSurname(String name, String surname);
}
