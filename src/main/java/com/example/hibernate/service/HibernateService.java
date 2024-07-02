package com.example.hibernate.service;

import com.example.hibernate.repository.HibernateRepository;
import com.example.hibernate.repository.Persons;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
