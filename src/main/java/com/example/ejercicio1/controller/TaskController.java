package com.example.ejercicio1.controller;

import com.example.ejercicio1.entity.TaskEntity;
import com.example.ejercicio1.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import com.example.ejercicio1.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping()
    public ResponseEntity<TaskEntity> createTask(@Valid @RequestBody TaskEntity task) {
        task = taskService.createTask(task);

        if(task == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(taskService.createTask(task));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> findById(@PathVariable Long id){
        TaskEntity task = taskService.getTaskById(id);
        if(task  == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(taskService.getTaskById(id));
    }
    @GetMapping("/first")
    public ResponseEntity<TaskEntity> findByFirst(){
        TaskEntity task = taskService.getFirst();
        if(task  == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(taskService.getFirst());
    }
    @GetMapping()
    public ResponseEntity<List<TaskEntity>> findAll(){
        List<TaskEntity> tasks = taskService.getAllTask();
        if(tasks.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(taskService.getAllTask());
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Long id, @Valid @RequestBody TaskEntity task) {
        TaskEntity Findtask = taskService.getTaskById(id);
        if(Findtask == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(taskService.updateTask(id, task));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskEntity> deleteTask(@PathVariable Long id){
        TaskEntity task = taskService.getTaskById(id);
        if(task == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(204).body(taskService.deleteTask(id));
    }
}
