package com.Person.PersonManager.model;


import lombok.Data;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String passwprd;

    @Column(name = "enabled")
    private boolean enabled ;


    @JoinColumn(name = "person_id")
    @OneToOne
    private Person person ;
}
