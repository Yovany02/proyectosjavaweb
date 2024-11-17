
package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado2RecuperarObjetoPersistence {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        // Definimos la variable
        Contacto contacto = null;
        
        em.getTransaction().begin();
        
        // Recuperamos el objeto
        contacto = em.find(Contacto.class, 3);
        
        em.getTransaction().commit();
        
        // Detached
        System.out.println("contacto = " + contacto);
        
    }
}
