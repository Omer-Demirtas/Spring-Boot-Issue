package com.Person.PersonManager.service;

import com.Person.PersonManager.model.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> getAllIssue(String username);

    Issue       saveIssue(Issue issue , String username);

    Issue       deleteIssue(long id);

    Issue       getone(long id);

    Issue       UpdateIssue(Issue issue , long id);

    Boolean     DeleteIssue(long id);
}
