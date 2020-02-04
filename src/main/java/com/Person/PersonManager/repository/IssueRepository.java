package com.Person.PersonManager.repository;

import com.Person.PersonManager.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    Issue findIssueById(long id);

    List<Issue> findIssueByPersonId(long id );

}
