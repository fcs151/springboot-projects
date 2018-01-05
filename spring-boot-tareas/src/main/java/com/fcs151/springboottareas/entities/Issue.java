package com.fcs151.springboottareas.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
@Table(name = "issue")
public class Issue extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -3257712986220091681L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
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
    
    private String createdAtFormatted;
}
