package com.jumboalimentos.SystemCallAndTask.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "software")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameSoftware;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id ;}

    public String getNameSystem() {return nameSoftware;}
    public void setNameSystem(String name) { this.nameSoftware = nameSoftware; }
}
