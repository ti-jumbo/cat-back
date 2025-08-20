package com.jumboalimentos.SystemCallAndTask.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sector")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameSector;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id ;}

    public String getNameSector() {return nameSector;}
    public void setNameSector(String nameSector) { this.nameSector = nameSector; }
}
