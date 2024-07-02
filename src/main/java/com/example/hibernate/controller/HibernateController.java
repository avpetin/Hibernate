package com.example.hibernate.controller;

import com.example.hibernate.repository.Persons;
import com.example.hibernate.service.HibernateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HibernateController {
    private HibernateService service;

    public HibernateController(HibernateService service){
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getCity(@RequestParam("city") String city){
        return service.getPersonsByCity(city);
    }
}
