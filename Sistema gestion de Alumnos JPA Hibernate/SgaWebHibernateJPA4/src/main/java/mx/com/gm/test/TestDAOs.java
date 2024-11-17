
package mx.com.gm.test;

import java.util.List;
import mx.com.gm.dao.AlumnoDAO;
import mx.com.gm.dao.AsignacionDAO;
import mx.com.gm.dao.ContactoDAO;
import mx.com.gm.dao.CursoDAO;
import mx.com.gm.dao.DomicilioDAO;

public class TestDAOs {
    public static void main(String[] args) {
        
        AlumnoDAO alumnoDao = new AlumnoDAO();
        System.out.println("Alumnos:");
        imprimir(alumnoDao.listar());
        
        System.out.println("Domicilios:");
        DomicilioDAO domicilioDao = new DomicilioDAO();
        imprimir(domicilioDao.listar());
        
        System.out.println("Contacto:");
        ContactoDAO contactoDAO = new ContactoDAO();
        imprimir(contactoDAO.listar());
        
        System.out.println("Cursos:");
        CursoDAO cursoDAO = new CursoDAO();
        imprimir(cursoDAO.listar());
        
        System.out.println("Asignacion:");
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        imprimir(asignacionDAO.listar());
 
    }
    
    private static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println("Valor = " + o);
        }
    }
    
}
