package com.example.ejercicio1.repository;

import com.example.ejercicio1.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}
