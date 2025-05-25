package com.example.demo.mapper;

import com.example.demo.persistence.entity.Task;
import com.example.demo.persistence.entity.TaskStatus;
import com.example.demo.service.dto.TaskInDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDtoToTask implements IMapper<TaskInDto, Task>{

    @Override
    public Task map(TaskInDto input) {
        Task task = new Task();
        task.setTittle(input.getTittle());
        task.setDescription(input.getDescription());
        task.setEta(input.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setCompleted(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }
}
