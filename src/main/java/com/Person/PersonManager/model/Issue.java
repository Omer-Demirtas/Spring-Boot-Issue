package com.Person.PersonManager.model;


import com.Person.PersonManager.dto.PersonDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "issue")
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String header;

    private String content;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private Person person ;

    @OneToOne()
    @JoinColumn(name = "issue_details")
    private IssueDetails issueDetails;
}
