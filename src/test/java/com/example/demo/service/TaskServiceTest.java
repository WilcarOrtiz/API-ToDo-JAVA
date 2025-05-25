package com.example.demo.service;

import com.example.demo.mapper.TaskInDtoToTask;
import com.example.demo.persistence.entity.Task;
import com.example.demo.persistence.entity.TaskStatus;
import com.example.demo.persistence.respository.TaskRepository;
import com.example.demo.service.dto.TaskInDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskInDtoToTask mapper;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTask() {
        TaskInDto dto = new TaskInDto();
        Task mappedTask = new Task();
        mappedTask.setId(1L);

        when(mapper.map(dto)).thenReturn(mappedTask);
        when(taskRepository.save(mappedTask)).thenReturn(mappedTask);

        Task result = taskService.createTask(dto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(mapper).map(dto);
        verify(taskRepository).save(mappedTask);
    }

    @Test
    void findAll() {
        List<Task> tasks = List.of(new Task(), new Task());
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.findAll();

        assertEquals(2, result.size());
        verify(taskRepository).findAll();
    }

    @Test
    void findAllByTaskStatus() {
        TaskStatus status = TaskStatus.ON_TIME;
        List<Task> filteredTasks = List.of(new Task(), new Task());
        when(taskRepository.findAllByTaskStatus(status)).thenReturn(filteredTasks);

        List<Task> result = taskService.findAllByTaskStatus(status);

        assertEquals(2, result.size());
        verify(taskRepository).findAllByTaskStatus(status);
    }
}
