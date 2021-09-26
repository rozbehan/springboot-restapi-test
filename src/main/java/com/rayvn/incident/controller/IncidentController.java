package com.rayvn.incident.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rayvn.incident.dao.IncidentRepository;
import com.rayvn.incident.model.Incident;

/**
 * This class includes incident APIs
 * @author Mahdi Rouzbahaneh
 */
@RestController
public class IncidentController {
    private IncidentRepository injectedIncident;

    /**
     * dependency injection (setter injection)
     * @param repository
     */
    @Autowired
    public void setInjectedBean(IncidentRepository repository) {
        this.injectedIncident = repository;
    }

    /**
     * Creation/Update of incident by id
     * @param incident
     * @return message string
     */
    @PostMapping("/saveIncident")
    public String saveIncident(@RequestBody Incident incident) {
        injectedIncident.save(incident);
        return "Incident saved..";
    }

    /**
     * List of all incidents
     * @return list of incidents
     */
    @GetMapping("/getAllIncidents")
    public List<Incident> getAllIncident() {
        return injectedIncident.findAll();
    }

    /**
     * Latest created incident
     * @return latest incident
     */
    @GetMapping("/getLatestIncident")
    public Incident getLatestIncident() {
        return injectedIncident.findTopByOrderByIdDesc();
    }

}