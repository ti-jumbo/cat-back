package com.jumboalimentos.SystemCallAndTask.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, name = "type_id")
    private Long type_id;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "applicant_id")
    private Long applicant_id;

    @Column(nullable = false)
    private Long sector_responsible_id;

    @Column
    private Long user_responsible_id;

    @Column
    private Long parent_task_id;
    
    @Column(nullable = false)
    private Long system_id;

    @Column(nullable = false)
    private Long status_id;

    @Column(nullable = false)
    private String contactWay;

    @Column
    private String contact;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "estimed_date")
    private LocalDateTime estimedDate;

    @Column(name = "completion_time")
    private LocalDateTime completionDate;

    @Column
    private String obs;

}