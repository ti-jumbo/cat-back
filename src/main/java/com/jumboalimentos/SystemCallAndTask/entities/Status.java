package com.jumboalimentos.SystemCallAndTask.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameStatus;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id ;}

    public String getNameStatus() {return nameStatus;}
    public void setNameStatus(String name) { this.nameStatus = nameStatus; }
}
