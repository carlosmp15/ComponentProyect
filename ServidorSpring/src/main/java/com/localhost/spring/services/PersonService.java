package com.localhost.spring.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localhost.spring.models.PersonModel;
import com.localhost.spring.repositories.IPersonReporitory;

@Service
public class PersonService {
    @Autowired
    private IPersonReporitory personRepository; // Dependencia inyectada
    
    // Método que devuelve todas las personas
    public ArrayList<PersonModel> getPersons() {
        return (ArrayList<PersonModel>) personRepository.findAll();
    }
    
    // Método para guardar una nueva persona
    public PersonModel savePerson(PersonModel person) {
        return personRepository.save(person);
    }
    
    // Método para obtener una persona por su id
    public Optional<PersonModel> getById(Long id) {
        return personRepository.findById(id);
    }
    
    // Método para actualizar una persona por su id
    public PersonModel updateById(PersonModel request, Long id) {
        Optional<PersonModel> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            PersonModel person = optionalPerson.get();
            person.setNombre(request.getNombre());
            person.setApellidos(request.getApellidos());
            return personRepository.save(person);
        } else {
            return null; // Manejo de caso en que la persona no existe
        }
    }
    
    // Método para eliminar una persona por su id
    public boolean deletePerson(Long id) {
        try {
            personRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
