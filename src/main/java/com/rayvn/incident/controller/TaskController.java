package com.rayvn.incident.controller;

import java.util.List;

import com.rayvn.incident.dao.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rayvn.incident.dao.TaskRepository;
import com.rayvn.incident.model.Incident;
import com.rayvn.incident.model.Task;

/**
 * This class includes task APIs
 * @author Mahdi Rouzbahaneh
 */
@RestController
public class TaskController {

    private TaskRepository injectedTask;
    private IncidentRepository injectedIncident;

    /**
     * dependency injection (setter injection)
     * @param incidentRepository
     * @param taskRepository
     */
    @Autowired
    public void setInjectedBean(IncidentRepository incidentRepository, TaskRepository taskRepository) {
        this.injectedIncident = incidentRepository;
        this.injectedTask = taskRepository;
    }

    /**
     * Creation/Update of task for incident by id
     * @param task
     * @return message string
     */
    @PostMapping("/saveTask")
    public String saveTask(@RequestBody Task task) {
        /* getById, unproxy, detach */
        final Incident incident = injectedIncident.findById(task.getIncident().getId()).get();
        task.setIncident(incident);
        injectedTask.save(task);
        return "Task saved..";
    }

    /**
     * List of all tasks by incident
     * @param id
     * @return List of tasks
     */
    @GetMapping("/getAllTasksByIncident")
    public List<Task> getAllTasks(@RequestBody String id) {
        return injectedTask.findByIncidentId(id);
    }

    /**
     * List of uncompleted tasks for an incident
     * @param id
     * @return List of tasks
     */
    @GetMapping("/getUncompletedTasksByIncident")
    public List<Task> getUncompletedTasks(@RequestBody String id) {
        return injectedTask.findByIncidentIdAndCompletedAtIsNull(id);
    }

    /**
     * List of uncompleted tasks that dueDate is passed for an incident
     * @param id
     * @return List of tasks
     */
    @GetMapping("/getExpiredTasksByIncident")
    public List<Task> getExpiredTasks(@RequestBody String id) {
        return injectedTask.findByIncidentIdAndCompletedAtIsNullAndDueDateIsBefore(id, System.currentTimeMillis());
    }

}
