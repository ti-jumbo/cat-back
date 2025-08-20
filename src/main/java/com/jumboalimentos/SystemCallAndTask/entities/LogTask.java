package com.jumboalimentos.SystemCallAndTask.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "log_tasks")
@Getter
@Setter
public class LogTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "sector_responsible_id", nullable = false)
    private Long sectorResponsibleId;

    @Column(name = "user_responsible_id",nullable = false)
    private Long userResponsibleId;

    @Column(name = "software_id", nullable = false)
    private Long softwareId;

    @Column(name = "type_id", nullable = false)
    private Long typeId;

    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @Column(name = "date_start")
    private LocalDateTime dateStart;

    @Column(name = "date_and_time_estimed" )
    private LocalDateTime dateAndTimeEstimed;

    @Column(name = "date_completed" )
    private LocalDateTime dateCompleted;

    @Column(name = "time_spent")
    private LocalDateTime timeSpent;

    @Column(name = "date_change")
    private LocalDateTime dateChange;

    @Column
    private String obs;

}