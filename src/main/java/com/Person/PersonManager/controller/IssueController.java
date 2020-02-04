package com.Person.PersonManager.controller;

import com.Person.PersonManager.model.Issue;
import com.Person.PersonManager.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequestMapping("/rest/issue")
@RestController
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService ;

    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    public Issue deleteIssue(@PathVariable("id") long id){
        return issueService.deleteIssue(id);
    }

    @PutMapping
    public Issue UpdateIssue(@PathVariable("{id}") long id, @RequestBody Issue issue){
        return issueService.UpdateIssue(issue , id);
    }

    @PostMapping
    public Issue saveIssue(@RequestBody Issue issue , Principal principal){
        return issueService.saveIssue(issue , principal.getName());
    }

    @GetMapping("/{id}")
    public Issue getIssue(@PathVariable("id") long id){
        return issueService.getone(id);
    }

    @GetMapping
    public List<Issue> getAllIssue(Principal principal){
        if(principal == null){
            return issueService.getAllIssue("ömer");
        }else{
            return issueService.getAllIssue(principal.getName());
        }
    }
}
