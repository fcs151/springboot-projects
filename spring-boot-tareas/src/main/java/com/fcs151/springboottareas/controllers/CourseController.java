package com.fcs151.springboottareas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fcs151.springboottareas.entities.Issue;
import com.fcs151.springboottareas.entities.Worker;
import com.fcs151.springboottareas.services.IssueService;

@RestController
public class CourseController {

    // marca que necesita el servicio como dependencia (lo inyecta)
    // spring crea la instancia y ve q clases necesitan la inyeccion de esa dependencia
    @Autowired
    private IssueService issueService;

    @RequestMapping("/workers/{workerId}/issues")
    public List<Issue> getAllIssues(@PathVariable int workerId) {
        return issueService.getAllIssues(workerId);
    }

    @RequestMapping("/workers/{workerId}/issues/{id}")
    public Issue getCourse(@PathVariable int id) {
        return issueService.getIssue(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/workers/{workerId}/issues")
    public void addCourse(@RequestBody Issue issue, @PathVariable int workerId) {
        issue.setWorker(new Worker(workerId));
        issueService.addIssue(issue);;
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/workers/{workerId}/issues/{id}")
    public void updateCourse(@RequestBody Issue issue, @PathVariable int workerId, @PathVariable int id) {
        issue.setWorker(new Worker(workerId));
        issueService.updateIssue(issue);;
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable int id) {
        issueService.deleteIssue(id);
    }
}
