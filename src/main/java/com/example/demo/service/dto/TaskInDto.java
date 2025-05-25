package com.example.demo.service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskInDto {
    private String tittle;
    private String description;
    private LocalDateTime eta;

}
