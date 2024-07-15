package com.example.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class HibernateRepository {
    @Autowired
    private final CrudRepository crudRepository;

    public HibernateRepository(CrudRepository crudRepository){
        this.crudRepository = crudRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Persons> getPersonsByCity(String city){
        return entityManager.createQuery(
                "select persons from Persons persons where persons.city = :city", Persons.class
                )
                .setParameter("city", city)
                .getResultList();
    }

    @Transactional
    public Object save(Persons persons){
        return crudRepository.save(persons);
    }

    @Transactional
    public Object findById(int id) {
        return crudRepository.findById(id);
    }

    @Transactional
    public List<Persons> findAll() {
        return crudRepository.findAll();
    }

    @Transactional
    public Object updatePhoneNumber(int id, String phoneNumber) {
        Optional<Persons> personOptional = crudRepository.findById(id);
        Persons person = personOptional.get();
        person.setPhoneNumber(phoneNumber);
        return crudRepository.save(person);
    }

    @Transactional
    public Object deleteById(int id) {
        Object person = findById(id);
        crudRepository.deleteById(id);
        return person;
    }

    @Transactional
    public List<Persons> findAllByAge(int age) {
        return crudRepository.findPersonsByUserAgeLessThanOrderByUserAge(age);
    }

    @Transactional
    public Optional<Persons> findAllByNameAndSurname(String name, String surname) {
        return crudRepository.findPersonsByUserNameAndUserSurname(name, surname);
    }
}
