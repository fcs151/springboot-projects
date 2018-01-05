package com.fcs151.springboottareas.services;

import static com.fcs151.springboottareas.utils.Utils.getFormatDate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcs151.springboottareas.entities.Issue;
import com.fcs151.springboottareas.entities.Worker;
import com.fcs151.springboottareas.repositories.IssueRepository;
import com.fcs151.springboottareas.repositories.WorkerRepository;

@Service
public class IssueService {
    
    @Autowired
    private IssueRepository issueRepository;
    
    @Autowired
    private WorkerRepository workerRepository;
    
    public List<Issue> getAllIssues() {
        List<Issue> issues = issueRepository.findAll();
        for (Issue issue : issues) {
            issue.setCreatedAtFormatted(getFormatDate(issue.getCreatedAt()));
        }
        return issues;
    }
    
    public List<Issue> getIssuesByWorker(int workerId){
        List<Issue> issues = new ArrayList<>();
        issueRepository.findByResponsibleId(workerId).forEach(issues::add);
        return issues;
    }
    
    public Issue getIssue(int id) {
        return issueRepository.findOne(id);
    }

    public void addIssue(Issue issue) {
        issueRepository.save(issue);
    }

    public void updateIssue(Issue issue) {
        issueRepository.save(issue);
    }

    public void deleteIssue(int id) {
        Issue issue = getIssue(id);
        issue.setEnabled(0);
        issueRepository.save(issue);
    }
    
    public Worker getWorker(int id) {
        return workerRepository.findOne(id);
    }
    
}
