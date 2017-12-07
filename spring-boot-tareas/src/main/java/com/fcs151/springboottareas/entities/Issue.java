package com.fcs151.springboottareas.entities;

import org.joda.time.DateTime;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Issue implements Serializable {

    private static final long serialVersionUID = -3900416629643035122L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "responsible")
    private Worker responsible;
    
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
    
    @Column(name = "enabled")
    private int enabled;
    
    @Column(name = "created_at")
    private DateTime createdAt;
    
    @Column(name = "updated_at")
    private DateTime updatedAt;
    
    public Issue() {
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
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Worker getResponsible() {
        return responsible;
    }

    public void setResponsible(Worker worker) {
        this.responsible = worker;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    
}
