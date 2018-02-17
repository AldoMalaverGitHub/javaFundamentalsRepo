/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacion.alumno.dao.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DCA
 */
public class Conexion {
    
    private Connection connection;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_alumno", "root", "mysql");
        } catch (ClassNotFoundException | SQLException ex ) {
            ex.printStackTrace();
        }
        
        return connection;
    }
}
