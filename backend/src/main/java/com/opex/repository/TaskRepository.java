package com.opex.repository;

import com.opex.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject_Id(Long projectId);
    
    @Query("SELECT COUNT(t) FROM Task t WHERE t.status = ?1")
    Long countByStatus(String status);
}