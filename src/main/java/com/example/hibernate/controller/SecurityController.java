package com.example.hibernate.controller;

import com.example.hibernate.repository.Persons;
import com.example.hibernate.service.HibernateService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class SecurityController {
    private final HibernateService service;

    public SecurityController(HibernateService service) {
        this.service = service;
    }

    //Данный запрос поиска по городу оставил без изменений (так же в репозитории)
    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/persons/by-city")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Persons> getMapping(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    //Добавление нового пользователя
    @RolesAllowed({"ROLE_WRITE"})
    @PostMapping("/persons/new_person")
    @ResponseStatus(code = HttpStatus.OK)
    public Object savePerson(@RequestBody Persons person) {
        return service.save(person);
    }

    //Поиск пользователей по id
    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object findById(@RequestParam("id") int id) {
        return service.findById(id);
    }

    //Вывод всех пользователей
    //Принимает в качестве параметра имя пользователя
    @PreAuthorize("authentication.principal.username == 'Vadim'")
    @GetMapping("/persons")
    @ResponseStatus(code = HttpStatus.OK)
    public Object findAll() {
        return service.findAll();
    }

    //Обновление номера телефона по id
    @RolesAllowed({"ROLE_WRITE"})
    @PostMapping("/persons/update-phone-by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object updatePhoneNumber(@RequestBody Persons persons) {
        int id = persons.getId();
        String phoneNumber = persons.getPhoneNumber();
        return service.updatePhoneNumber(id, phoneNumber);
    }

    //Поиск по году
    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/persons/by-age-less")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Persons> getPersonsByAgeLess(@RequestParam("age") Integer age) {
        return service.getPersonsByAgeLess(age);
    }

    //Поиск по имени и фамилии
    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-name-and-surname")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Persons> getPersonsByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname
    ) {
        return service.getPersonsByNameAndSurname(name, surname);
    }

    //Удаление по id
    @PostAuthorize("hasAnyRole('WRITE') or hasAnyRole('DELETE')")
    @DeleteMapping("/persons/delete-by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object delete(@RequestParam("id") int id) {
        return service.deleteById(id);
    }
}
