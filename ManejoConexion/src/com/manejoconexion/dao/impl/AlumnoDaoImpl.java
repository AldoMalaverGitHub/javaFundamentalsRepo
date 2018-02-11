/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manejoconexion.dao.impl;

import com.manejoconexion.dao.AlumnoDao;
import com.manejoconexion.dao.entities.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import manejoconexion.Conexion;

/**
 *
 * @author DCA
 */
public class AlumnoDaoImpl implements AlumnoDao{

    @Override
    public int guardarAlumno(Alumno alumno) {
        int resultado = 0;
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO alumno(nombres, " +
                "apellidoPaterno, apellidoMaterno, " +
                "telefono, direccion) VALUES(?,?,?,?,?)";
        
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, alumno.getNombres());
            pstmt.setString(2, alumno.getApellidoPaterno());
            pstmt.setString(3, alumno.getApellidoMaterno());
            pstmt.setString(4, alumno.getTelefono());
            pstmt.setString(5, alumno.getDireccion());
            
            resultado = pstmt.executeUpdate();
            
        }catch(SQLException ex){
           
        }finally{
            try{
               if(connection != null)
                   connection.close();
               if(pstmt != null)
                   pstmt.close();
           }catch(SQLException sqlex){
               
           } 
        }
        
        return resultado;
    }

    @Override
    public List<Alumno> traerAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
