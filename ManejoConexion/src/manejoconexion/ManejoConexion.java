/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoconexion;

import com.manejoconexion.dao.AlumnoDao;
import com.manejoconexion.dao.entities.Alumno;
import com.manejoconexion.dao.impl.AlumnoDaoImpl;

/**
 *
 * @author DCA
 */
public class ManejoConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlumnoDao alumnoDao = new AlumnoDaoImpl();
        Alumno alumno = new Alumno();
        alumno.setNombres("Angel");
        alumno.setApellidoPaterno("Romero");
        alumno.setApellidoMaterno("Valdez");
        alumno.setDireccion("xyz");
        alumno.setTelefono("123456789");
        int resultado = alumnoDao.guardarAlumno(alumno);
        System.out.println(resultado == 1? "Guardo"
                :"No guardo");
    }
    
}
