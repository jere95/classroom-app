package com.myjclassroom.classroomapp.controller;

import com.myjclassroom.classroomapp.model.dto.PersonDTO;
import com.myjclassroom.classroomapp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> findPerson(@PathVariable Long id){
        PersonDTO personDTO= personService.getPersonById(id);
        if(null == personDTO){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll(){
        List<PersonDTO> personDTOList = personService.findAll();
        if(null == personDTOList){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personDTOList, HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody PersonDTO personDTO){
        personService.savePerson(personDTO);
    }
}
