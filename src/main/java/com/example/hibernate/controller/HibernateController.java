package com.example.hibernate.controller;

import com.example.hibernate.repository.Persons;
import com.example.hibernate.service.HibernateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HibernateController {
    private final HibernateService service;

    public HibernateController(HibernateService service){
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getCity(@RequestParam("city") String city){
        return service.getPersonsByCity(city);
    }

    @PostMapping("/persons")
    @ResponseStatus(code = HttpStatus.OK)
    public Object savePerson(@RequestBody Persons person) {
        return service.savePersons(person);
    }

    @GetMapping("/persons/by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object findById(@RequestParam("id") int id) {
        return service.findById(id);
    }

    @GetMapping("/persons")
    @ResponseStatus(code = HttpStatus.OK)
    public Object findAll() {
        return service.findAll();
    }

    @PostMapping("/persons/update-phone-by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object updatePhoneNumber(@RequestBody Persons persons) {
        int id = persons.getId();
        String phoneNumber = persons.getPhoneNumber();
        return service.updatePhoneNumber(id, phoneNumber);
    }

    @GetMapping("/persons/by-age-less")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Persons> getPersonsByAgeLess(@RequestParam("age") Integer age) {
        return service.getPersonsByAgeLess(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Persons> getPersonsByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname
    ) {
        return service.getPersonsByNameAndSurname(name, surname);
    }

    @DeleteMapping("/persons/delete-by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object delete(@RequestParam("id") int id) {
        return service.deleteById(id);
    }
}
