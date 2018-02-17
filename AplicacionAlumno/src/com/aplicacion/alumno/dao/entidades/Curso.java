/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacion.alumno.dao.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DCA
 */
public class Curso {

    private int idCurso;
    private String nombre;
    private String descripcion;
    private int estado;
    private List<AlumnoCurso> alumnoCurso = new ArrayList<>();

    public Curso(int idCurso, String nombre, String descripcion, int estado) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }  
    
    /**
     * @return the idCurso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the alumnoCurso
     */
    public List<AlumnoCurso> getAlumnoCurso() {
        return alumnoCurso;
    }

    /**
     * @param alumnoCurso the alumnoCurso to set
     */
    public void setAlumnoCurso(List<AlumnoCurso> alumnoCurso) {
        this.alumnoCurso = alumnoCurso;
    }
   
}
