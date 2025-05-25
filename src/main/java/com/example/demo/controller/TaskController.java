package com.example.demo.controller;

import com.example.demo.persistence.entity.Task;
import com.example.demo.persistence.entity.TaskStatus;
import com.example.demo.service.TaskService;
import com.example.demo.service.dto.TaskInDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDto taskInDto){
        return this.taskService.createTask(taskInDto);
    }

    @GetMapping
    public List<Task> getTasks(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{taskStatus}")
    public List<Task> findAllBystatus(@PathVariable("taskStatus") TaskStatus taskStatus){
        return this.taskService.findAllByTaskStatus(taskStatus);
    }


}
