package com.Person.PersonManager.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonDto {

    private String name;
    private String surname;
    private int  age;
}
