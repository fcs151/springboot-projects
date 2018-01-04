package com.fcs151.springboottareas.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fcs151.springboottareas.entities.Issue;
import com.fcs151.springboottareas.entities.Worker;
import com.fcs151.springboottareas.exceptions.IssueDoesNotExistException;
import com.fcs151.springboottareas.exceptions.WorkerDoesNotExistException;
import com.fcs151.springboottareas.services.IssueService;

@RestController
public class IssueController {

    private static final Logger logger = Logger.getLogger(IssueController.class);
    
    @Autowired
    private IssueService issueService;
    
    /**
     * Get all issues.
     * @return list of all the issues
     */
    @RequestMapping("/issues")
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }
    
    /**
     * Get all worker's Issues
     * @param workerId worker's id
     * @return list of worker's issues
     */
    @RequestMapping("/workers/{workerId}/issues")
    public List<Issue> getIssuesByWorkerId(@PathVariable int workerId) {
        return issueService.getIssuesByWorker(workerId);
    }

    /**
     * Get one specific issue.
     * @param id identifier of the issue.
     * @return the issue.
     */
    @RequestMapping("/issues/{id}")
    public Issue getIssue(@PathVariable int id) {
        Issue issue = issueService.getIssue(id);
        if (issue!=null) return issue;
        else {
            logger.info("Issue doesn't exist. Id: " + id);
            throw new IssueDoesNotExistException(id);
        }
    }

    /**
     * Add a new worker's issue.
     * @param issue
     * @param workerId
     */
    @RequestMapping(method=RequestMethod.POST, value="/workers/{workerId}/issues")
    public void addIssue(@RequestBody Issue issue, @PathVariable int workerId) {
        issue.setResponsible(new Worker(workerId));
        issueService.addIssue(issue);
    }
    
    /**
     * Update an issue
     * @param issue in the RequestBody
     * @param workerId issue's responsible
     * @param id id of the issue
     * @throws Exception 
     */
    @RequestMapping(method=RequestMethod.PUT, value="/issues/{id}")
    public void updateIssue(@RequestBody Issue issue, @PathVariable int id) throws Exception {
        issue.setId(id);
        if (issueService.getIssue(id)!=null) issueService.updateIssue(issue);
        else {
            logger.info("Issue doesn't exist. Id: " + id);
            throw new IssueDoesNotExistException(id);
        }
    }
    
    /**
     * Delete an issue.
     * @param id
     */
    @RequestMapping(method=RequestMethod.DELETE, value="/issues/{id}")
    public void deleteIssue(@PathVariable int id) {
        if (issueService.getIssue(id)!=null) issueService.deleteIssue(id);
        else {
            logger.info("Issue doesn't exist. Id: " + id);
            throw new IssueDoesNotExistException(id);
        }
    }
    
    /**
     * Get one specific worker.
     * @param id identifier of the issue.
     * @return the issue.
     */
    @RequestMapping("/workers/{id}")
    public Worker getWorker(@PathVariable int id) {
        Worker worker = issueService.getWorker(id);
        if (worker!=null) return worker;
        else {
            logger.info("Worker doesn't exist. Id: " + id);
            throw new WorkerDoesNotExistException(id);
        }
    }

}
