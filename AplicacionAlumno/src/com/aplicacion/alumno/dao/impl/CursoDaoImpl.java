/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacion.alumno.dao.impl;

import com.aplicacion.alumno.dao.CursoDao;
import com.aplicacion.alumno.dao.conexion.Conexion;
import com.aplicacion.alumno.dao.entidades.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DCA
 */
public class CursoDaoImpl implements CursoDao {

    @Override
    public int guardarCurso(Curso curso) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        PreparedStatement pstmt = null;
        int resultado = 0;
        String sql = "Insert into Curso values(?,?,?,?)";
        
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, curso.getIdCurso());
            pstmt.setString(2, curso.getNombre());
            pstmt.setString(3, curso.getDescripcion());
            pstmt.setInt(4, curso.getEstado());
            
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
    
    
    
}
