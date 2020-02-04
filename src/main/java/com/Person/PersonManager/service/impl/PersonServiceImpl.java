package com.Person.PersonManager.service.impl;


import com.Person.PersonManager.dto.PersonDto;
import com.Person.PersonManager.model.Authorities;
import com.Person.PersonManager.model.Issue;
import com.Person.PersonManager.model.Person;
import com.Person.PersonManager.model.User;
import com.Person.PersonManager.repository.AuthoritiesRepository;
import com.Person.PersonManager.repository.IssueRepository;
import com.Person.PersonManager.repository.PersonRepository;
import com.Person.PersonManager.repository.UserRepository;
import com.Person.PersonManager.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService
{
    private final AuthoritiesRepository authoritiesRepository ;
    private final IssueRepository  issueRepository ;
    private final PersonRepository personRepository;
    private final UserRepository   userRepository  ;
    PersonServiceImpl(AuthoritiesRepository authoritiesRepository , PersonRepository personRepository , IssueRepository issueRepository , UserRepository userRepository){
        this.personRepository = personRepository ;
        this.issueRepository  = issueRepository  ;
        this.userRepository   = userRepository   ;
        this.authoritiesRepository = authoritiesRepository ;
    }

    @Override
    public List<PersonDto> getAllPerson() {
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : personRepository.findAll()){
            PersonDto personDto = new PersonDto();
            personDto.setName(person.getName());
            personDto.setSurname(person.getSurname());
            personDtoList.add(personDto);
        }
        return personDtoList;
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        //convert PersonDto to Person
        Person personDb = new Person();
        personDb.setName(personDto.getName());
        personDb.setAge(personDto.getAge());
        personDb.setSurname(personDto.getSurname());
        personRepository.save(personDb);

        //Create User
        User user = new User();
        user.setUsername(personDb.getName());//default
        user.setPasswprd("{noop}123");
        user.setPerson(personDb);
        user.setEnabled(true);
        userRepository.save(user);

        //Create Authorities
        Authorities authorities = new Authorities();
        authorities.setUsername(user.getUsername());
        authorities.setAuthority("ROLE_USER"); //default
        authoritiesRepository.save(authorities);

        //Default Issue:
        Issue issue = new Issue();
        issue.setHeader("bu ilk mesajınız !!");
        issue.setContent("bu menuden kendinize özel notlar tutabilirsiniz...");
        issue.setPerson(personDb);
        issueRepository.save(issue);
        return personDto ;
    }
}
