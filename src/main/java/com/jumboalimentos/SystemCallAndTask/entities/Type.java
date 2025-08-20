package com.jumboalimentos.SystemCallAndTask.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameType;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id ;}

    public String getNameType() {return nameType;}
    public void setNameType(String name) { this.nameType = nameType; }
}
