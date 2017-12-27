package com.fcs151.springboottareas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fcs151.springboottareas.entities.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
    public List<Issue> findByResponsibleId(Integer workerId);

    public Issue findByName(String name);
}
