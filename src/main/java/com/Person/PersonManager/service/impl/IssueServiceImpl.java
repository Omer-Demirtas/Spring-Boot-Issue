package com.Person.PersonManager.service.impl;

import com.Person.PersonManager.dto.IssueDto;
import com.Person.PersonManager.dto.PersonDto;
import com.Person.PersonManager.model.Issue;
import com.Person.PersonManager.model.IssueDetails;
import com.Person.PersonManager.model.Person;
import com.Person.PersonManager.repository.IssueDetailsRepository;
import com.Person.PersonManager.repository.IssueRepository;
import com.Person.PersonManager.repository.PersonRepository;
import com.Person.PersonManager.repository.UserRepository;
import com.Person.PersonManager.service.IssueService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Service
public class IssueServiceImpl implements IssueService {
    private final UserRepository   userRepository   ;
    private final IssueRepository  issueRepository  ;
    private final PersonRepository personRepository ;
    private final IssueDetailsRepository issueDetailsRepository ;
    IssueServiceImpl(IssueDetailsRepository issueDetailsRepository , UserRepository userRepository , IssueRepository issueRepository , PersonRepository personRepository){
        this.issueDetailsRepository = issueDetailsRepository ;
        this.issueRepository  = issueRepository;
        this.personRepository = personRepository;
        this.userRepository   = userRepository;
    }

    @Override
    public List<Issue> getAllIssue(String username) {
        System.out.println(username);
        if (username == null){
            username = "ömer";
        }
        System.out.println(userRepository.findByUsername(username).getPerson());
        if (personRepository.findPersonByName(username) == null){
            return null ;
        }else{
            return issueRepository.findIssueByPersonId(personRepository.findPersonByName(username).getId()) ;
        }
    }

    @Override//burada username yerine userRepository den alınan
    @Transactional//username den user ın oradan da person ın bylunması gerek
    public Issue saveIssue(Issue issue ,String username) {
        //Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Person    personDb  = userRepository.findByUsername(username).getPerson();
        IssueDetails issueDetails = new IssueDetails();
        IssueDetails issueDetailsDb = issueDetailsRepository.save(issueDetails);
        issueDetailsDb.setCreatedDate(date);
        issue.setIssueDetails(issueDetailsDb);
        issue.setPerson(personDb);
        issueRepository.save(issue);
        System.out.println(issue);
        return issue;
    }

    @Override
    public Issue deleteIssue(long id) {
        System.out.println(issueRepository.findIssueById(id));
        issueRepository.deleteById(issueRepository.findIssueById(id).getId());
        return issueRepository.findIssueById(id);
    }

    @Override
    public Issue getone(long id) {
        return issueRepository.findIssueById(id);
    }

    @Override
    public Issue UpdateIssue(Issue issue, long id) {
        Issue issueDb = issueRepository.findIssueById(id);
        issueDb.setHeader(issue.getHeader());
        issueDb.setContent(issue.getContent());

        //Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        IssueDetails issueDetailsDb = issueDb.getIssueDetails();
        issueDetailsDb.setUpdatedDate(date);
        issueDb.setIssueDetails(issueDetailsDb);
        return issueDb;
    }

    @Transactional
    @Override
    public Boolean DeleteIssue(long id) {
        try{
            issueRepository.deleteById(id);
            return true;
        }catch(IllegalArgumentException hata) {
            return false;
        }
    }
}
