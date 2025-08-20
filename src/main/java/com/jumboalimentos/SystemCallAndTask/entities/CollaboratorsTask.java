package com.jumboalimentos.SystemCallAndTask.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "collaborators_task")
public class CollaboratorsTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long tarefa_id;

    @Column
    private Long usuario_id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id ;}

    public Long getTarefa_id() { return id; }
    public void setTarefa_id(Long id) { this.id = id ;}

    public Long getUsuario_id() { return id; }
    public void setUsuario_id(Long id) { this.id = id ;}

}
