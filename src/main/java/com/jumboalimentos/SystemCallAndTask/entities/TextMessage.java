package com.jumboalimentos.SystemCallAndTask.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "message")
@Getter
@Setter
public class TextMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tarefa_id")
    private Long tarefaId;

    @Column(name = "user_id")
    private Long userId;

    @Column
    private String message;

    @Column
    private LocalDateTime dateToSend;

}
