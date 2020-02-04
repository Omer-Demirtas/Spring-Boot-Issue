package com.Person.PersonManager.repository;

import com.Person.PersonManager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person , Long> {
    Person findPersonByName(String name);

}
