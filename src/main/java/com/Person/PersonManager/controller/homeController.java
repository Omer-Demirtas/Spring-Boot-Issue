package com.Person.PersonManager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class homeController {

    @RequestMapping(value = "/issue")
    public String IssueList(){
        return "issue-list";
    }

    @RequestMapping(value = "/person")
    public String PersonList(){
        return "person-list";
    }

    @RequestMapping(value = "/home")
    public String Home(){
        return "home-page";
    }

    @RequestMapping(value = "/")
    public String MainPage(){
        return "home-page";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/addperson")
    public String addPerson(){
        return "add-person";
    }

    @RequestMapping(value = "/addissue")
    public String addIssue(){
        return "add-issue";
    }


}
