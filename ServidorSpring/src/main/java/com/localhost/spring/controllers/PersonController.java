package com.localhost.spring.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localhost.spring.models.PersonModel;
import com.localhost.spring.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    // Obtiene todas las personas
    @GetMapping
    public ArrayList<PersonModel> getPersons() {
        return personService.getPersons();
    }
    
    // Crea una nueva persona
    @PostMapping
    public PersonModel savePerson(@RequestBody PersonModel person) {
        return personService.savePerson(person);
    }
    
    // Obtiene la persona por su id
    @GetMapping("/{id}")
    public Optional<PersonModel> getPersonById(@PathVariable("id") Long id) {
        return personService.getById(id);
    }
    
    // Actualiza una persona por su id
    @PutMapping("/{id}")
    public PersonModel updateById(@RequestBody PersonModel request, @PathVariable("id") Long id) {
        return personService.updateById(request, id);
    }
    
    // Elimina una persona por su id
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean deleted = personService.deletePerson(id);
        if (deleted) {
            return "La persona con id " + id + " ha sido eliminada exitosamente.";
        } else {
            return "No se pudo eliminar la persona con id " + id + ". Verifique el ID proporcionado.";
        }
    }
}
