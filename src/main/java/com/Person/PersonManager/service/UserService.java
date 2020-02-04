package com.Person.PersonManager.service;

import com.Person.PersonManager.model.Person;
import com.Person.PersonManager.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user , Person person);

    List<User> getUsers();
}
