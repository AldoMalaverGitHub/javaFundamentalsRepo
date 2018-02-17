/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionalumno;

import com.aplicacion.alumno.dao.AlumnoCursoDao;
import com.aplicacion.alumno.dao.AlumnoDao;
import com.aplicacion.alumno.dao.CursoDao;
import com.aplicacion.alumno.dao.entidades.Alumno;
import com.aplicacion.alumno.dao.entidades.AlumnoCurso;
import com.aplicacion.alumno.dao.entidades.Curso;
import com.aplicacion.alumno.dao.impl.AlumnoCursoDaoImpl;
import com.aplicacion.alumno.dao.impl.AlumnoDaoImpl;
import com.aplicacion.alumno.dao.impl.CursoDaoImpl;
import java.util.List;

/**
 *
 * @author DCA
 */
public class AplicacionAlumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlumnoDao alumnoDao = new AlumnoDaoImpl();
     /*    Alumno alumno = new Alumno(0, "Luis", 
                "Heysen", "M", "123456789", 
                "Av. Los olvidados 123", 1);
               
       int resultado = alumnoDao.guardarAlumno(alumno);
        
        System.out.println(resultado==1? 
                "Se guardo con exito"
                : "Error al guardar");*/
    
    /*    List<Alumno> listaAlumnos = alumnoDao.listarAlumnos();
        
        for(Alumno alumno: listaAlumnos){
            System.out.println(alumno.getNombres() + " " 
                    + alumno.getApellidos());
        }
        
        listaAlumnos.forEach(alumno -> 
                System.out.println(alumno.getNombres() + " " 
                    + alumno.getApellidos()));

*/
    /*    CursoDao cursoDao = new CursoDaoImpl();
        Curso curso = new Curso(0, "Java 8 Developer", "Developer", 1);
        int resultado = cursoDao.guardarCurso(curso);
        
        System.out.println(resultado == 1? 
                "Se guardo con exito"
                : "Error al guardar");
*/
    
        AlumnoCursoDao alumnoCursoDao = new AlumnoCursoDaoImpl();
 /*       AlumnoCurso alumnoCurso = new AlumnoCurso();
        alumnoCurso.setIdAlumnoCurso(0);
        alumnoCurso.setIdAlumno(2);
        alumnoCurso.setIdCurso(2);
        alumnoCurso.setEstado(1);
        int resultado = alumnoCursoDao.guardarAlumnoCurso(alumnoCurso);
        
        System.out.println(resultado == 1? 
                "Se guardo con exito"
                : "Error al guardar");
    */
 
        List<Alumno> listaAlumnos = alumnoDao.listarAlumnos();

        for(Alumno alumno: listaAlumnos){
            System.out.println(alumno.getNombres() + " " 
                    + alumno.getApellidos()); 
            List<Curso> listaCursos = alumnoCursoDao
                    .obtenerCursosAsignados(alumno.getIdAlumno());
            
            for(Curso curso: listaCursos){
               System.out.println("\t" + curso.getIdCurso() + 
                       " " + curso.getNombre());
            }
            
        }
    }
    
}
