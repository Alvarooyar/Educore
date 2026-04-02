package com.eduCore.eduCore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Incripcion {
    @Id
    private Integer id;

    //nombre completo del estudiante
    private String nombreEstudiante;
    //nombre del curso
    private String curso;
    // se encuentra activo o no
    private boolean estado;
    // se encuentra activo o no
    private String fecha;
    //categoria diurno o vespertino
    private String modalidad;
    //nivel o semestre
    private Integer nivel;

    //constructor vacio
    public Incripcion() {
    }
    //contructor con argumentos
    public Incripcion(Integer id, String nombreEstudiante, String curso, boolean estado, String fecha, String modalidad, Integer nivel) {
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.curso = curso;
        this.estado = estado;
        this.fecha = fecha;
        this.modalidad = modalidad;
        this.nivel = nivel;
    }

    //getter and setters
    public Integer id() {
        return id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}



