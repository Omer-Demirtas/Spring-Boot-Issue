package com.Person.PersonManager.repository;

import com.Person.PersonManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    User  findByUsername(String username);

}
