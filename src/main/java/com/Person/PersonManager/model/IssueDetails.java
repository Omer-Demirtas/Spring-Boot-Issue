package com.Person.PersonManager.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "issue_details")
@Data
public class IssueDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name =  "create_date")
    private Date createdDate ;

    @Column(name = "updated_date")
    private Date updatedDate ;


}
