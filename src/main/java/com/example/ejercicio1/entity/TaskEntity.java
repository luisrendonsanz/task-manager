package com.example.ejercicio1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    private boolean completado;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String titulo, String descripcion, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletado() {
        return completado;
    }
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

}
