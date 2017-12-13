package com.fcs151.springboottareas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class State {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    public State() {
    }

    public State(Integer id, String name) {
        super();
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
