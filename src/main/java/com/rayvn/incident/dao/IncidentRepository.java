package com.rayvn.incident.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayvn.incident.model.Incident;

public interface IncidentRepository extends JpaRepository<Incident, String> {

    Incident findTopByOrderByIdDesc();
    Incident getById(String s);

}
