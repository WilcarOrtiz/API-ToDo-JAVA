package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) /*Genera Id */
    private Long id;
    private String tittle;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean completed;
    private TaskStatus taskStatus;


}
