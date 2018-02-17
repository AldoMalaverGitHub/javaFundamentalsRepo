/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacion.alumno.dao.impl;

import com.aplicacion.alumno.dao.AlumnoCursoDao;
import com.aplicacion.alumno.dao.conexion.Conexion;
import com.aplicacion.alumno.dao.entidades.Alumno;
import com.aplicacion.alumno.dao.entidades.AlumnoCurso;
import com.aplicacion.alumno.dao.entidades.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DCA
 */
public class AlumnoCursoDaoImpl implements AlumnoCursoDao {

    @Override
    public int guardarAlumnoCurso(AlumnoCurso alumnoCurso) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        PreparedStatement pstmt = null;
        int resultado = 0;
        String sql = "Insert into AlumnoCurso values(?,?,?,?)";
        
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, alumnoCurso.getIdAlumnoCurso());
            pstmt.setInt(2, alumnoCurso.getIdAlumno());
            pstmt.setInt(3, alumnoCurso.getIdCurso());
            pstmt.setInt(4, alumnoCurso.getEstado());
            
            resultado = pstmt.executeUpdate();
            
        }catch(SQLException ex){
            
        }finally{
            try{
                if(conn != null) conn.close();
                if(pstmt  != null) pstmt.close();
            }catch(SQLException ex1){
                
            }
        }
        
        return resultado;        
    }

    @Override
    public List<Curso> obtenerCursosAsignados(int idAlumno) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        PreparedStatement pstmt = null;
        String sql = "Select c.* from AlumnoCurso ac, Curso c where "
                + "ac.idCurso = c.idCurso AND ac.idAlumno = ?";
        List<Curso> listaCursos = new ArrayList<>();
        ResultSet rs = null;
        
        try{
           pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, idAlumno);
           rs = pstmt.executeQuery();
           
           while(rs.next()){
               Curso curso = new Curso(rs.getInt(1), rs.getString(2),
               rs.getString(3), rs.getInt(4));
               listaCursos.add(curso);
           }
           
        }catch(SQLException ex){
          
        }finally{
            try{
               if(conn != null) conn.close();
               if(pstmt != null) pstmt.close();
               if(rs != null) rs.close();
            } catch(SQLException ex1){
               
            }
        }
        
        return listaCursos;
    }    
}
