package com.example.ejercicio1.service;

import com.example.ejercicio1.entity.TaskEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import com.example.ejercicio1.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    public TaskEntity getFirst() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        return taskEntities.getFirst();
    }

    public List<TaskEntity> getAllTask(){
        return taskRepository.findAll();
    }

    public TaskEntity createTask(TaskEntity newTask){
        return taskRepository.save(newTask);
    }
    public TaskEntity updateTask(Long id, TaskEntity newTask){
        TaskEntity task = taskRepository.findById(id).orElse(null);
        if(task != null){
            task.setTitulo(newTask.getTitulo());
            task.setDescripcion(newTask.getDescripcion());
            task.setCompletado(newTask.isCompletado());
            return taskRepository.save(task);
        }
        return null;
    }
    public TaskEntity deleteTask(Long id){
        TaskEntity task = taskRepository.findById(id).orElse(null);
        taskRepository.deleteById(id);
        return task;
    }
}
