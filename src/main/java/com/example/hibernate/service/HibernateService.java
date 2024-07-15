package com.example.hibernate.service;

import com.example.hibernate.repository.HibernateRepository;
import com.example.hibernate.repository.Persons;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HibernateService {
    private HibernateRepository repository;

    public HibernateService(HibernateRepository repository){
        this.repository = repository;
    }

    public List<Persons> getPersonsByCity(String city){
        return repository.getPersonsByCity(city);
    }

    public Object save(Persons persons) {
        return repository.save(persons);
    }

    public Object findById(int id) {
        return repository.findById(id);
    }

    public List<Persons> findAll() {
        return repository.findAll();
    }

    public Object updatePhoneNumber(int id, String phoneNumber) {
        return repository.updatePhoneNumber(id, phoneNumber);
    }

    public List<Persons> getPersonsByAgeLess(int age) {
        return repository.findAllByAge(age);
    }

    public Optional<Persons> getPersonsByNameAndSurname(String name, String surName) {
        return repository.findAllByNameAndSurname(name, surName);
    }

    public Object deleteById(int id) {
        return repository.deleteById(id);
    }
}
