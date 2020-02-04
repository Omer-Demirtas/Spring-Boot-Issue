package com.Person.PersonManager.service.impl;

import com.Person.PersonManager.model.Person;
import com.Person.PersonManager.model.User;
import com.Person.PersonManager.repository.UserRepository;
import com.Person.PersonManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User saveUser(User user , Person person) {
        user.setPerson(person);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
