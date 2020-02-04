package com.Person.PersonManager.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username" , length = 25)
    private String username;

    @Column(name = "authority" , length = 25)
    private String authority;
}
