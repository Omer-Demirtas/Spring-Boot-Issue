package com.Person.PersonManager.controller;


import com.Person.PersonManager.dto.PersonDto;
import com.Person.PersonManager.service.PersonService;
import com.Person.PersonManager.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/person")
public class PersonController {
    private final UserService   userService   ;
    private final PersonService personService ;
    PersonController(PersonService personService , UserService userService){
        this.personService = personService ;
        this.userService   = userService   ;
    }

    @GetMapping
    public List<PersonDto> getAllPerson(){
        return  personService.getAllPerson();
    }

    @PostMapping
    public PersonDto save(@RequestBody PersonDto personDto){
        return personService.save(personDto);
    }


}
