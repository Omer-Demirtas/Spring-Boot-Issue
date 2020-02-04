package com.Person.PersonManager.repository;

import com.Person.PersonManager.model.IssueDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueDetailsRepository extends JpaRepository<IssueDetails , Long> {
}
