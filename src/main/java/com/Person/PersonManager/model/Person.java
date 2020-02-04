package com.Person.PersonManager.model;


import com.Person.PersonManager.dto.PersonDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table( name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname ;

    @Column(name = "age")
    private int age ;

}
