package com.myjclassroom.classroomapp.services;

import com.myjclassroom.classroomapp.model.dto.PersonDTO;
import com.myjclassroom.classroomapp.model.entity.Person;
import com.myjclassroom.classroomapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public void savePerson(PersonDTO personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setLastName(personDTO.getLastName());
        repository.save(person);
    }


    public PersonDTO getPersonById(Long id) {
        Optional<Person> personOptional = repository.findById(id);
        if(personOptional.isPresent()){
            return personToPersonDTO(personOptional.get());
        }
        return null;
    }

    public List<PersonDTO> findAll() {
        List<Person> personList = repository.findAll();
        List<PersonDTO> personDTOList = new ArrayList<>();

        if(personList.isEmpty()){
            return null;
        }

        for (Person person : personList){
            personDTOList.add(personToPersonDTO(person));
        }

        return personDTOList;

    }

    private static PersonDTO personToPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(person.getName());
        personDTO.setLastName(person.getLastName());
        return personDTO;
    }
}
