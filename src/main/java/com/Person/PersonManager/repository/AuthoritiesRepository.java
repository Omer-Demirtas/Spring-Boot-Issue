package com.Person.PersonManager.repository;


import com.Person.PersonManager.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities , Long> {
}
