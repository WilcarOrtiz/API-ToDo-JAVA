package com.example.demo.service;

import com.example.demo.mapper.TaskInDtoToTask;
import com.example.demo.persistence.entity.Task;
import com.example.demo.persistence.entity.TaskStatus;
import com.example.demo.persistence.respository.TaskRepository;
import com.example.demo.service.dto.TaskInDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    /*wilcar comentarios*/

    /*comentarios para sonarCloud*/
    private final TaskRepository taskRepository;
    private final TaskInDtoToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDtoToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDto taskInDto){
        Task task = mapper.map(taskInDto);
        return this.taskRepository.save(task);
    }

    public List<Task> findAll(){
        return this.taskRepository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus){
        return this.taskRepository.findAllByTaskStatus(taskStatus);
    }
}
