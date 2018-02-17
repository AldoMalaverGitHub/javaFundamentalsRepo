/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacion.alumno.dao.impl;

import com.aplicacion.alumno.dao.AlumnoDao;
import com.aplicacion.alumno.dao.conexion.Conexion;
import com.aplicacion.alumno.dao.entidades.Alumno;
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
public class AlumnoDaoImpl implements AlumnoDao{

    @Override
    public int guardarAlumno(Alumno alumno) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        PreparedStatement pstmt = null;
        String sql = "Insert into Alumno values(?,?,?,?,?,?,?)";
        int resultado = 0;
        try{
           pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, alumno.getIdAlumno());
           pstmt.setString(2, alumno.getNombres());
           pstmt.setString(3, alumno.getApellidos());
           pstmt.setString(4, alumno.getSexo());
           pstmt.setString(5, alumno.getTelefono());
           pstmt.setString(6, alumno.getDireccion());
           pstmt.setInt(7, alumno.getEstado());
           resultado = pstmt.executeUpdate();
        }catch(SQLException ex){
          
        }finally{
            try{
               if(conn != null) conn.close();
               if(pstmt != null) pstmt.close();
            } catch(SQLException ex1){
               
            }
        }
        
        return resultado;
    }

    @Override
    public List<Alumno> listarAlumnos() {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        PreparedStatement pstmt = null;
        String sql = "Select * from Alumno";
        List<Alumno> listaAlumnos = new ArrayList<>();
        ResultSet rs = null;
        
        try{
           pstmt = conn.prepareStatement(sql);
           rs = pstmt.executeQuery();
           
           while(rs.next()){
               Alumno alumno = new Alumno(rs.getInt(1), rs.getString(2),
               rs.getString(3), rs.getString(4), rs.getString(5),
               rs.getString(6), rs.getInt(7));
               listaAlumnos.add(alumno);
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
        
        return listaAlumnos;
    }
    
}
