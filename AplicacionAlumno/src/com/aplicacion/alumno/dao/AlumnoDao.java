/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacion.alumno.dao;

import com.aplicacion.alumno.dao.entidades.Alumno;
import java.util.List;

/**
 *
 * @author DCA
 */
public interface AlumnoDao {
    
    int guardarAlumno(Alumno alumno);
    
    List<Alumno> listarAlumnos();
}
