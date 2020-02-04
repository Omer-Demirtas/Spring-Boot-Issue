package com.Person.PersonManager.service;


import com.Person.PersonManager.dto.PersonDto;
import com.Person.PersonManager.model.Person;

import java.util.List;

public interface  PersonService {

    List<PersonDto> getAllPerson();

    PersonDto save(PersonDto person);
}
