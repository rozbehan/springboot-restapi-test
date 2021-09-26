package com.rayvn.incident.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rayvn.incident.model.Task;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface TaskRepository extends
        JpaRepository<Task, String>,
        PagingAndSortingRepository<Task, String>,
        JpaSpecificationExecutor<Task>
{
    List<Task> findByIncidentId(String incidentId);
    List<Task> findByIncidentIdAndCompletedAtIsNull(String incidentId);
    @Query("select t from Task t where t.incident.id = :incidentId and t.dueDate < :currentDate")
    List<Task> findByIncidentIdAndCompletedAtIsNullAndDueDateIsBefore(String incidentId, @Param("currentDate") long currentDate);

}
