package com.fcs151.springboottareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcs151.springboottareas.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    
}
