/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoconexion;

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
            String url = "jdbc:mysql://localhost:3306/db_matricula?zeroDateTimeBehavior=convertToNull";
            String user = "root";
            String password = "mysql";
            Class.forName("com.mysql.jdbc.Driver");           
            connection = DriverManager
                    .getConnection(url, user, password);
                  
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        
        }catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }       
        
        return connection;
    }
    
}
